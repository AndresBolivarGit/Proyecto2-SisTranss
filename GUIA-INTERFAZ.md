# Guía Rápida - Interfaz Gráfica ALPESCAB

Esta es una guía paso a paso para usar la interfaz gráfica web del sistema ALPESCAB.

---

### 1. Iniciar la Aplicación

Corre el proyecto desde tu IDE

### 2. Abrir el Navegador

Navega a: **http://localhost:8080**

---

## 📋 Guía de Requisitos Funcionales (RF)

### RF1 - Registrar Ciudad

1. Click en "Requisitos Funcionales"
2. Click en "RF1 - Registrar Ciudad"
3. Ingresa el nombre (Ej: "Barranquilla")
4. Click en "Registrar Ciudad"

**Ciudades ya existentes:** Bogotá, Medellín, Cali

---

### RF2 - Usuario de Servicios

1. Navega a RF2
2. Completa los datos del usuario:
   - **Cédula:** >= 50001 (para nuevos usuarios)
   - **Nombre:** Nombre completo
   - **Correo:** usuario@example.com
   - **Celular:** Opcional
3. Completa los datos de la tarjeta:
   - **Número:** 4111111111111111
   - **Nombre:** Como aparece en la tarjeta
   - **Vencimiento:** Fecha futura
   - **CVV:** 3-4 dígitos
4. Click en "Registrar Usuario de Servicios"

**Usuarios existentes:** 2001-2200

---

### RF3 - Usuario Conductor

1. Navega a RF3
2. Completa los datos:
   - **Cédula:** >= 60001 (para nuevos conductores)
   - **Nombre:** Nombre completo
   - **Correo:** conductor@example.com
   - **Celular:** Opcional
3. Click en "Registrar Conductor"

**Conductores existentes:** 1001-1100

---

### RF4 - Registrar Vehículo

1. Navega a RF4
2. Completa los datos:
   - **Placa:** Única (Ej: XYZ789)
   - **Tipo:** carro, camioneta, motocicleta o PICKUP
   - **Marca:** Ej: Toyota
   - **Modelo:** Año (1990-2025)
   - **Color:** Ej: Blanco
   - **Ciudad Placa:** Bogotá, Medellín o Cali (exacto)
   - **Capacidad:** 1-20 pasajeros
   - **Nivel:** ESTANDAR, CONFORT o LARGE
   - **Cédula Dueño:** Conductor existente (1001-1100)
3. Click en "Registrar Vehículo"

**Placas existentes (NO usar):** AUT001-AUT100, MOTO01-MOTO50

---

### RF5 - Registrar Disponibilidad

1. Navega a RF5
2. Completa los datos:
   - **Cédula Conductor:** 1001-1100
   - **Placa Vehículo:** AUT001-AUT100
   - **Día:** Fecha futura (para evitar conflictos)
   - **Franja Horaria:** Formato HH:MM-HH:MM (Ej: 08:00-12:00)
   - **Tipo Transporte:** Selecciona uno
3. Click en "Registrar Disponibilidad"

**Importante:** No pueden haber franjas superpuestas en el mismo día.

---

### RF6 - Modificar Disponibilidad

1. Navega a RF6
2. Necesitas el **ID de la disponibilidad** a modificar
3. Completa los nuevos datos
4. Click en "Modificar Disponibilidad"

---

### RF7 - Punto Geográfico

1. Navega a RF7
2. Completa los datos:
   - **Dirección:** Calle 123 #45-67
   - **Ciudad:** Debe existir (Bogotá, Medellín, Cali)
   - **Coordenadas:** Formato lat,lon (Ej: 4.6097,-74.0817)
   - **Tipo:** Partida, Destino o Ambos
3. Click en "Registrar Punto"

**Puntos existentes:** IDs 1-20

---

### RF8 - Solicitar Servicio

1. Navega a RF8
2. Completa los datos básicos:
   - **Cédula Solicitante:** 2001-2200 o >= 50001
   - **Punto Partida:** 1-20
   - **Punto Destino:** 1-20
   - **Tipo Servicio:** Selecciona uno
   - **Tarjeta:** Asociada al usuario
3. Según el tipo seleccionado, aparecerán campos adicionales:
   - **Transporte Pasajeros:** Nivel (Estándar/Confort/Large)
   - **Entrega Comida:** Nombre del restaurante
   - **Transporte Mercancía:** Peso en kg
4. Click en "Solicitar Servicio"

---

### RF9 - Finalizar Servicio

1. Navega a RF9
2. Completa los datos:
   - **ID Servicio:** Servicios activos: 201, 202, 203
   - **Distancia:** Ej: 5.5 km
   - **Costo Total:** En pesos (Ej: 25000)
3. Click en "Finalizar Servicio"

**Servicios de prueba:** 201, 202, 203 (pre-creados como activos)

---

### RF10 - Reseña Usuario a Conductor

1. Navega a RF10
2. Completa los datos:
   - **Cédula Usuario (Autor):** El pasajero (Ej: 2001)
   - **Cédula Conductor (Evaluado):** El conductor (Ej: 1001)
   - **ID Servicio:** Servicio finalizado (Ej: 1)
   - **Calificación:** 0-5 estrellas
   - **Comentario:** Opcional
3. Click en "Enviar Reseña"

**Combinaciones válidas:**
- Servicio 1: Usuario 2001 → Conductor 1001
- Servicio 2: Usuario 2002 → Conductor 1002
- Servicio 3: Usuario 2003 → Conductor 1003

---

### RF11 - Reseña Conductor a Usuario

1. Navega a RF11
2. Completa los datos:
   - **Cédula Conductor (Autor):** El conductor (Ej: 1005)
   - **Cédula Usuario (Evaluado):** El pasajero (Ej: 2005)
   - **ID Servicio:** Servicio finalizado (Ej: 5)
   - **Calificación:** 0-5 estrellas
   - **Comentario:** Opcional
3. Click en "Enviar Reseña"

**Combinaciones válidas:**
- Servicio 5: Conductor 1005 → Usuario 2005
- Servicio 6: Conductor 1006 → Usuario 2006
- Servicio 7: Conductor 1007 → Usuario 2007

---

## Guía de Consultas (RFC)

### RFC1 - Historial de Servicios

1. Navega a "Consultas" → "RFC1 - Historial"
2. Ingresa:
   - **Cédula Conductor:** 1001-1100
   - **Límite:** Cantidad de servicios a mostrar (Ej: 10)
3. Click en "Consultar Historial"
4. Se mostrará una tabla con los servicios del conductor

---

### RFC2 - Top 10 Conductores

1. Navega a "Consultas" → "RFC2 - Top Conductores"
2. Los datos se cargan automáticamente
3. Verás una tabla con los 10 conductores mejor calificados

---

### RFC3 - Ganancias por Vehículo

1. Navega a "Consultas" → "RFC3 - Ganancias"
2. Ingresa:
   - **Cédula Conductor:** 1001-1100
3. Click en "Consultar Ganancias"
4. Se mostrará una tabla con las ganancias de cada vehículo del conductor

---

### RFC4 - Uso del Servicio

1. Navega a "Consultas" → "RFC4 - Uso del Servicio"
2. Selecciona el rango de fechas:
   - **Desde:** Fecha y hora de inicio
   - **Hasta:** Fecha y hora de fin
3. Click en "Consultar Estadísticas"
4. Se mostrarán estadísticas agrupadas por mes y tipo de servicio

---

## Flujo de Prueba Completo

### Escenario 1: Nuevo Conductor y Servicio

1. **RF3:** Registrar conductor (Cédula: 60001)
2. **RF4:** Registrar vehículo (Placa: TEST001, Dueño: 60001)
3. **RF5:** Crear disponibilidad (Conductor: 60001, Vehículo: TEST001)
4. **RF2:** Registrar usuario de servicios (Cédula: 50001)
5. **RF8:** Solicitar servicio (Solicitante: 50001)
6. **RF9:** Finalizar servicio
7. **RF10:** Usuario deja reseña al conductor
8. **RF11:** Conductor deja reseña al usuario

### Escenario 2: Consultas con Datos Existentes

1. **RFC2:** Ver top conductores (datos inmediatos)
2. **RFC1:** Historial del conductor 1001
3. **RFC3:** Ganancias del conductor 1001
4. **RFC4:** Estadísticas del último mes

---

## Consejos

1. **Siempre limpia la base de datos** antes de hacer pruebas completas:

2. **Usa fechas futuras** para disponibilidades para evitar conflictos

3. **Verifica las cédulas** antes de crear reseñas

4. **Consulta los datos pre-poblados** en el README para saber qué IDs usar

5. **Lee los mensajes de información** en cada formulario para guiarte

---

