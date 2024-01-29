BEGIN TRANSACTION;

DROP TABLE IF EXISTS fitness_activity, fitness_goal, nutrition_entry;
DROP TABLE IF EXISTS fitness_user;


DROP SEQUENCE IF EXISTS seq_activity_id ,seq_goal_id, seq_nutrition_id;
DROP SEQUENCE IF EXISTS seq_auth_user_id;


-- Sequence to start user_id values at 1001 instead of 1
CREATE SEQUENCE seq_auth_user_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;

CREATE TABLE fitness_user (
	user_id int NOT NULL DEFAULT nextval('seq_auth_user_id'),
	username VARCHAR(50) NOT NULL,
	email VARCHAR(50),
	password_hash varchar(200) NOT NULL,
	height FLOAT,
	weight FLOAT,
	age int,
	CONSTRAINT PK_fitness_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);


CREATE SEQUENCE seq_activity_id
INCREMENT BY 1
START WITH 2001
NO MAXVALUE;

CREATE TABLE fitness_activity (
    activity_id int DEFAULT nextval('seq_activity_id'),
    user_id int,
    activity_type VARCHAR(50) NOT NULL,
    intensity VARCHAR(50),
    notes TEXT,
    duration_hours INT,
    duration_minutes INT,
    date VARCHAR;
	CONSTRAINT PK_fitness_activity PRIMARY KEY (activity_id),
    CONSTRAINT FK_fitness_activity_user FOREIGN KEY (user_id) REFERENCES fitness_user(user_id)
);


CREATE SEQUENCE seq_goal_id
INCREMENT BY 1
START WITH 3001
NO MAXVALUE;


CREATE TABLE fitness_goal (
    goal_id int NOT NULL DEFAULT nextval('seq_goal_id'),
    user_id INT,
    goal_type VARCHAR(255) NOT NULL,
    start_date VARCHAR,
    end_date VARCHAR,
    action_plan TEXT,
	CONSTRAINT PK_fitness_goal PRIMARY KEY (goal_id),
    CONSTRAINT FK_fitness_goal_user FOREIGN KEY (user_id) REFERENCES fitness_user(user_id)
);


CREATE SEQUENCE seq_nutrition_id
INCREMENT BY 1
START WITH 4001
NO MAXVALUE;


CREATE TABLE nutrition_entry (
    nutrition_id int NOT NULL DEFAULT nextval('seq_nutrition_id'),
    user_id INT,
    food_name VARCHAR(255) NOT NULL,
    calories FLOAT,
    proteins FLOAT,
    carbs FLOAT,
    fats FLOAT,
    entry_date DATE DEFAULT CURRENT_DATE,
	CONSTRAINT PK_nutrition_entry PRIMARY KEY (nutrition_id),
    CONSTRAINT FK_nutrition_entry_user FOREIGN KEY (user_id) REFERENCES fitness_user(user_id)
);

COMMIT;
