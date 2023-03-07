package cl.turismoreal.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tipo_gasto")
public class TipoGasto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_gasto")
	private Long idTipoGasto;
	
	@Column(name = "nomb_tipo_gasto")
    private String nombreTipoGasto;

	private static final long serialVersionUID = 1L;
}
