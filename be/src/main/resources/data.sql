/* Dummy data for testing and development */

/* Users dummy data */
INSERT INTO users (username, `password`, dog_name, `group`) VALUES ('testingClient', 'password', 'dog1', 'client');
INSERT INTO users (username, `password`, dog_name, `group`) VALUES ('testingRaiser', 'password', 'dog2', 'raiser');
INSERT INTO users (username, `password`, `group`) VALUES ('testingStaff', 'password', 'staff');

/* Lessons dummy data */
INSERT INTO lessons (title, `description`, lesson_type) VALUES ('Lesson 1', 'This is a client lesson', 'client');
INSERT INTO lessons (title, `description`, lesson_type) VALUES ('Lesson 2', 'This is a raiser lesson', 'raiser');
INSERT INTO lessons (title, `description`, lesson_type) VALUES ('Lesson 3', 'This is a staff lesson', 'staff');

/* Tasks dummy data */
INSERT INTO tasks (lesson_id, title, `description`) VALUES (1, 'Task 1', 'This is a client task');
INSERT INTO tasks (lesson_id, title, `description`) VALUES (2, 'Task 2', 'This is a raiser task');
INSERT INTO tasks (lesson_id, title, `description`) VALUES (3, 'Task 3', 'This is a staff task');

/* Screens dummy data */
INSERT INTO screens (title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('Screen 1', 1, 'This is a client screen', 'https://www.pawswithacause.org/wp-content/themes/paws/graphics/header-logo.png', 'https://www.youtube.com/watch?v=uRF9HLpTDyE', false);
INSERT INTO screens (title, task_id, `text`, only_instruction) VALUES ('Screen 2', 1, 'This is a client screen', true);

INSERT INTO screens (title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('Screen 1', 2, 'This is a raiser screen', 'https://www.pawswithacause.org/wp-content/themes/paws/graphics/header-logo.png', 'https://www.youtube.com/watch?v=uRF9HLpTDyE', false);
INSERT INTO screens (title, task_id, `text`, only_instruction) VALUES ('Screen 2', 2, 'This is a raiser screen', true);

INSERT INTO screens (title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('Screen 1', 3, 'This is a staff screen', 'https://www.pawswithacause.org/wp-content/themes/paws/graphics/header-logo.png', 'https://www.youtube.com/watch?v=uRF9HLpTDyE', false);
INSERT INTO screens (title, task_id, `text`, only_instruction) VALUES ('Screen 2', 3, 'This is a staff screen', true);

