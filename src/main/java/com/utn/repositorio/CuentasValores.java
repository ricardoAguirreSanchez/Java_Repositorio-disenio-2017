package com.utn.repositorio;

import com.utn.model.Cuenta;
import com.utn.model.CuentaValores;
import com.utn.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by nicolaslamas on 18/11/17.
 */
public interface CuentasValores extends CrudRepository<CuentaValores, Long> {
    List<CuentaValores> findCuentaValoresByCuentaId(long cuentaId);

    CuentaValores findCuentaValoresByCuentaIdAndFechaInicioAndFechaFin(Long cuentaId, Date fechaInicio, Date fechaFin);
    /*
    public CuentasValores(EntityManager em) {
        super();
        this.em = em;
    }

    public CuentaValores buscarPorId(Long id) {
        return em.find(CuentaValores.class, id);
    }

    public void persistir(CuentaValores cv) {
        em.getTransaction().begin();
        em.persist(cv);
        em.getTransaction().commit();
    }

    public Long getCuentaValorId(long cuentaId, String fechaInicio, String fechaFin){


        TypedQuery<CuentaValores> query = em.createQuery("SELECT cv from CuentaValores cv where cv.cuenta.id = ? and DATE_FORMAT(cv.fechaInicio ,'%Y-%m-%d')=? " +
                "AND DATE_FORMAT(cv.fechaFin,'%Y-%m-%d')=?", CuentaValores.class)
                .setParameter(0, cuentaId)
                .setParameter(1, fechaInicio)
                .setParameter(2, fechaFin);

        List<CuentaValores> cvl = query.getResultList();
        return cvl.isEmpty() ? 0L : cvl.stream().findFirst().get().getId();
    } */
}
