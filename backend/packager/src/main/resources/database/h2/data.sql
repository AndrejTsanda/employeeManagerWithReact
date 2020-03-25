INSERT INTO users (user_name, user_password) VALUES
  ('admin', '$2a$10$7D9ySeF9QNfas4jF2JwG0OjjaqMTne6kDkK5txNjfAwE/E3WPPtDS'),
  ('user', '$2a$10$AQNcYi7q7KKw7oWoK0NAHe7zRZDJb/LKpBAd2CceonDTWsz0TKyrW');

INSERT INTO departments (department_name) VALUES
  ('Accounting department'),
  ('Personnel department'),
  ('Management department');

INSERT INTO employees (tabelNum, firstName, lastName, email, gender, birthday, department_id) VALUES
  (73000, 'Svetlana', 'Demidova', 'demidova.svetlana@gmail.com', 'female', '1991-12-02', 1),
  (74000, 'Anastasiya', 'Demidova', 'demidova.anastasiya@gmail.com', 'female', '2000-04-14', 2),
  (75000, 'Ivan', 'Sidorov', 'sidorov.ivan@gmail.com', 'male', '1965-06-30', 3),
  (76000, 'Galina', 'Nesterova', 'nesterova.galina@gmail.com', 'female', '1972-01-11', 1);