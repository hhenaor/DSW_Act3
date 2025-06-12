package com.ejemplo.actividad3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "asignaturas")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "course_id", nullable = false)
    private String courseId;
    
    private String nombre;
    private String nombreCompleto;
    private String descripcion;
    private String areaConocimiento;
    private String carrera;
    private Integer numeroCreditos;
    private String contenidoTematico;
    private Integer semestre;
    private String profesor;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Usuario usuario;
    
    // Constructors
    public Asignatura() {}
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public String getAreaConocimiento() { return areaConocimiento; }
    public void setAreaConocimiento(String areaConocimiento) { this.areaConocimiento = areaConocimiento; }
    
    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }
    
    public Integer getNumeroCreditos() { return numeroCreditos; }
    public void setNumeroCreditos(Integer numeroCreditos) { this.numeroCreditos = numeroCreditos; }
    
    public String getContenidoTematico() { return contenidoTematico; }
    public void setContenidoTematico(String contenidoTematico) { this.contenidoTematico = contenidoTematico; }
    
    public Integer getSemestre() { return semestre; }
    public void setSemestre(Integer semestre) { this.semestre = semestre; }
    
    public String getProfesor() { return profesor; }
    public void setProfesor(String profesor) { this.profesor = profesor; }
    
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

}