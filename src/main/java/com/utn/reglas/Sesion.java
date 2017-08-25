package com.utn.reglas;

import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Sesion {

	public WorkingMemory iniciar()  {

		PackageBuilder packageBuilder = new PackageBuilder();

		String ruleFile = "/com/utn/reglas/Reglas.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

		Reader reader = new InputStreamReader(resourceAsStream);
		try {
			packageBuilder.addPackageFromDrl(reader);
		} catch (Exception e) {
			System.out.println("Error al iniciar la sesion");;
		}
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();

		return workingMemory;
	}

}
