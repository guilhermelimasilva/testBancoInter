--jobs
insert into job(id, name, active, parent_job_id) values (1, 'Job 3', true, null);
insert into job(id, name, active, parent_job_id) values (2, 'Job 1', true, 1);
insert into job(id, name, active, parent_job_id) values (3, 'Job 4', true, 2);
insert into job(id, name, active, parent_job_id) values (4, 'Job 2', true, null);

--tasks
insert into task(id, name, weight, completed, created_at, job_id) values (1, 'Task 1', 3.0, true, '2018-05-10',  1);
insert into task(id, name, weight, completed, created_at, job_id) values (2, 'Task 2', 1.0, true, '2018-05-11',  2);
insert into task(id, name, weight, completed, created_at, job_id) values (3, 'Task 3', 2.0, true, '2018-05-08',  4);