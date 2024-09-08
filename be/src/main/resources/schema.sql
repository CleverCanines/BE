CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE, 
    `password` VARCHAR(255) NOT NULL, /* Remember to be hashed and salted */
    dog_name VARCHAR(255), /* Null if user does not have a dog, or are staff. */
    `group` ENUM('client', 'raiser', 'staff') NOT NULL
);


/*
    Lesson tab related tables
*/
CREATE TABLE IF NOT EXISTS lessons (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    `description` TEXT,
    lesson_type ENUM('client', 'raiser', 'staff') NOT NULL
);

CREATE TABLE IF NOT EXISTS tasks (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    lesson_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    `description` TEXT,
    FOREIGN KEY (lesson_id) REFERENCES lessons(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS screens (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    task_id INT NOT NULL,
    `text` TEXT,
    image_url VARCHAR(255),
    video_url VARCHAR(255),
    only_instruction BOOLEAN,
    FOREIGN KEY (task_id) REFERENCES tasks(id) ON DELETE CASCADE
);
