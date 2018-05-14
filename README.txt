
Olá, foi um prazer executar esse teste, foi desafiador e fonte de aprendizado e pratica. Infelizmente, não pude completar a tarefa. Pude dedicar pouco tempo nesse fim de semana.
Mas enfim, espero que seja possível fazer a avaliação necessária e desejo receber os feedbacks.

Aplicação:

Para rodar a aplicação utilize o comando:

mvn spring-boot:run

No diretório (src\main\resources) possui um arquivo chamado import.sql, que permite que o banco de dados seja pré carregado.

API:
A api é dividida em dois contoles com os seguintes métodos:

Jobs:
localhost:8080/jobs
Métodos:
1	Tipo: Get
	localhost:8080/jobs/?orderByWeight=<boolean> - Retorna todos os jobs cadastrados. Ordenados ou não (orderByWeight), pela soma dos pesos das tasks associadas a ele.
2	Tipo: Post
	localhost:8080/jobs/ - Cria um novo Job, inserindo as informações do enviadas no bodyrequest.
3   Tipo: Get
	localhost:8080/jobs/{id<Integer>} - Retorna o Job com o id informado.
4	Tipo: Put
	localhost:8080/jobs/{id<Integer>} - Edita o Job com o id informado, inserindo as informações do enviadas no bodyrequest.
5 	Tipo: Delete
	localhost:8080/jobs/{id<Integer>} - Deleta o Job com o id informado.

Tasks:
localhost:8080/tasks
Métodos:
1	Tipo: Get
	localhost:8080/tasks/?orderByWeight=<boolean> - Retorna todos as tasks cadastrados ordenadas pela data de criação (createdAt).
2	Tipo: Post
	localhost:8080/tasks/ - Cria uma nova Task, inserindo as informações do enviadas no bodyrequest.
3   Tipo: Get
	localhost:8080/tasks/{id<Integer>} - Retorna a Task com o id informado.
4	Tipo: Put
	localhost:8080/tasks/{id<Integer>} - Edita a Task com o id informado, inserindo as informações do enviadas no bodyrequest.
5 	Tipo: Delete
	localhost:8080/tasks/{id<Integer>} - Deleta a Task com o id informado.

Para a chamada dos métodos http utilizei a aplicação Postman: https://www.getpostman.com/