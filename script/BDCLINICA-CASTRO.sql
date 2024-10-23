DROP DATABASE IF EXISTS BDCLINICA_CASTRO;
CREATE DATABASE IF NOT EXISTS BDCLINICA_CASTRO;
USE BDCLINICA_CASTRO;

CREATE TABLE Paciente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(15),
    fechanacimiento DATE
);
CREATE TABLE Medicamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10, 2) NOT NULL
);
CREATE TABLE Especialidad (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255)
);
CREATE TABLE Doctor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    idespecialidad INT NOT NULL,
    telefono VARCHAR(15),
    correo VARCHAR(100),
    FOREIGN KEY (idespecialidad) REFERENCES Especialidad(id)
);
CREATE TABLE Cita (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idpaciente INT NOT NULL,
    iddoctor INT NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    motivo VARCHAR(255),
    FOREIGN KEY (idpaciente) REFERENCES Paciente(id),
    FOREIGN KEY (iddoctor) REFERENCES Doctor(id)
);
CREATE TABLE RecetaMedica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idcita INT NOT NULL,
    idmedicamento INT NOT NULL,
    instrucciones VARCHAR(255),
    FOREIGN KEY (idcita) REFERENCES Cita(id),
    FOREIGN KEY (idmedicamento) REFERENCES Medicamento(id)
);

INSERT INTO Paciente (nombre, direccion, telefono, fechanacimiento) VALUES
('Juan Pérez', 'Av. Siempre Viva 123', '987654321', '1985-07-15'),
('María García', 'Calle Falsa 456', '912345678', '1990-10-22'),
('Luis Mendoza', 'Jr. Las Flores 789', '921234567', '1978-03-09'),
('Ana Romero', 'Av. Los Pinos 101', '934567890', '1982-12-05'),
('Carlos Ruiz', 'Jr. Lima 202', '923456789', '1995-01-15'),
('Rosa Flores', 'Av. La Paz 303', '911223344', '1988-06-30'),
('Jorge Valdez', 'Jr. El Sol 404', '922233344', '1979-11-20'),
('Patricia Ríos', 'Av. Las Palmeras 505', '931234567', '1993-05-25');

INSERT INTO Medicamento (nombre, descripcion, precio) VALUES
('Paracetamol', 'Analgésico y antipirético', 5.00),
('Ibuprofeno', 'Antiinflamatorio y analgésico', 8.50),
('Amoxicilina', 'Antibiótico', 12.00),
('Loratadina', 'Antihistamínico', 4.50),
('Metformina', 'Medicamento para la diabetes', 18.00),
('Omeprazol', 'Inhibidor de la bomba de protones', 7.00),
('Atorvastatina', 'Reductor de colesterol', 15.00),
('Losartán', 'Antihipertensivo', 10.00);

INSERT INTO Especialidad (nombre, descripcion) VALUES
('Cardiología', 'Especialidad médica del corazón'),
('Neurología', 'Especialidad médica del sistema nervioso'),
('Ginecología', 'Especialidad médica de la salud femenina'),
('Pediatría', 'Especialidad médica para niños'),
('Dermatología', 'Especialidad médica de la piel'),
('Endocrinología', 'Especialidad médica del sistema endocrino'),
('Urología', 'Especialidad médica del aparato urinario'),
('Oncología', 'Especialidad médica del tratamiento del cáncer');

INSERT INTO Doctor (nombre, idespecialidad, telefono, correo) VALUES
('Dr. José Salazar', 1, '987654321', 'jsalazar@clinica.com'),
('Dra. Carmen Silva', 2, '912345678', 'csilva@clinica.com'),
('Dr. Luis Torres', 3, '934567890', 'ltorres@clinica.com'),
('Dra. Ana Gutiérrez', 4, '923456789', 'agutierrez@clinica.com'),
('Dr. Carlos Vega', 5, '911223344', 'cvega@clinica.com'),
('Dra. María Zamora', 6, '922233344', 'mzamora@clinica.com'),
('Dr. Jorge Muñoz', 7, '931234567', 'jmunoz@clinica.com'),
('Dra. Patricia Ortiz', 8, '921234567', 'portiz@clinica.com');

INSERT INTO Cita (idpaciente, iddoctor, fecha, hora, motivo) VALUES
(1, 1, '2024-10-01', '09:00:00', 'Chequeo general'),
(2, 2, '2024-10-02', '10:30:00', 'Dolor de cabeza'),
(3, 3, '2024-10-03', '11:15:00', 'Examen ginecológico'),
(4, 4, '2024-10-04', '12:00:00', 'Control de crecimiento'),
(5, 5, '2024-10-05', '08:45:00', 'Problema en la piel'),
(6, 6, '2024-10-06', '14:30:00', 'Chequeo endocrino'),
(7, 7, '2024-10-07', '15:00:00', 'Problema urinario'),
(8, 8, '2024-10-08', '16:45:00', 'Consulta sobre tratamiento de cáncer');

INSERT INTO RecetaMedica (idcita, idmedicamento, instrucciones) VALUES
(1, 1, 'Tomar 1 tableta cada 8 horas'),
(2, 2, 'Tomar 1 tableta cada 12 horas'),
(3, 3, 'Tomar según lo indicado por el doctor'),
(4, 4, 'Tomar 1 tableta diaria'),
(5, 5, 'Tomar 1 tableta antes de cada comida'),
(6, 6, 'Tomar 1 cápsula diaria en ayunas'),
(7, 7, 'Tomar 1 tableta cada noche'),
(8, 8, 'Tomar 1 tableta dos veces al día');

