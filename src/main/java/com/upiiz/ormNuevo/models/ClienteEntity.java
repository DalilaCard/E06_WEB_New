package com.upiiz.ormNuevo.models;

import jakarta.persistence.*;
//Validacion antes de ingresa s la b ase
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

//constructor con paramtro
@AllArgsConstructor
//contructor sin args
@NoArgsConstructor
//Mapear con ORM, Reducir codigo con lombok y validar campos

//Mapear con tabla - Clase
@Entity
//ClientEntity -> Cliente
@Table(name = "cliente")
public class ClienteEntity {
    //el manejador de datos genere el id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Si se quiere un nombre especifico direfente al de la clase

    @NotBlank
    @Size(min=3, message = "El nombre debe de tener al menos 3 caracteres")
    @Column(name = "nombre_cliente")
    private String nombre;

    @NotBlank(message = "Se debe de ingresar un apellido")
    private String apellido;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Pattern(regexp = "[0-9]{10}")
    private String telefono;

    @NotBlank
    private String direccion;

    @Min(18)
    private int edad;

    @NotBlank
    //@Pattern(regexp = "")
    private String rfc;
}