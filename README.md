"# andaluciaskills" 

## ParticipanteServiceImpl

1️⃣ createParticipante(Participante participante)

@Override
@Transactional
public Participante createParticipante(Participante participante)

🔹 Descripción:

Este método crea un nuevo participante y lo asigna a una especialidad existente.

🔹 Parámetros:

participante: Participante - Objeto que contiene la información del participante a crear.

🔹 Flujo de ejecución:

- Busca la especialidad por ID (participante.getEspecialidad().getIdEspecialidad()).
- Si la especialidad no existe, lanza una EspecialidadNotFoundException.
- Asigna la especialidad al participante.
- Guarda el participante en la base de datos.

🔹 Excepciones:

EspecialidadNotFoundException → Si la especialidad asociada no existe.

🔹 Retorno:

Devuelve el Participante creado con su especialidad asignada.

2️⃣ getParticipanteById(Long participanteId)

@Override
public Participante getParticipanteById(Long participanteId)

🔹 Descripción:

Este método recupera un participante por su ID.

🔹 Parámetros:

participanteId: Long/Identificador único del participante.

🔹 Flujo de ejecución:

- Busca el participante en la base de datos.
- Si el participante no existe, lanza una ParticipanteNotFoundException.
- Devuelve el participante encontrado.

🔹 Excepciones:

ParticipanteNotFoundException → Si el participante no se encuentra en la base de datos.

🔹 Retorno:

Devuelve el objeto Participante si se encuentra en la base de datos.

3️⃣ getPruebasDeParticipante(Long participanteId)

@Override
public List<Prueba> getPruebasDeParticipante(Long participanteId)

🔹 Descripción:

Este método obtiene todas las pruebas asignadas a un participante a través de su especialidad.

🔹 Parámetros:

participanteId: Long - Identificador único del participante.

🔹 Flujo de ejecución:

- Busca el participante por su ID (getParticipanteById(participanteId)).
- Obtiene la especialidad del participante.
- Devuelve la lista de pruebas asociadas a la especialidad del participante.

🔹 Excepciones:

ParticipanteNotFoundException → Si el participante no existe en la base de datos.

🔹 Retorno:

Devuelve una lista de Prueba asociadas a la especialidad del participante.