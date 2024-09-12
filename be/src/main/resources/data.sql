/* Dummy data for testing and development */

/* Users dummy data */
-- INSERT INTO users (username, `password`, dog_name, `group`) VALUES ('testingClient', 'password', 'dog1', 'client');
-- INSERT INTO users (username, `password`, dog_name, `group`) VALUES ('testingRaiser', 'password', 'dog2', 'raiser');
-- INSERT INTO users (username, `password`, `group`) VALUES ('testingStaff', 'password', 'staff');

/* Lessons dummy data */
INSERT INTO lesson (id, order_index, title, `description`, lesson_type, lesson_week) VALUES ('4b902cd9-059f-4159-acb5-0a714975aaf0', 1, 'Lesson 1', 'This is a client lesson', 'client', 1);
INSERT INTO lesson (id, order_index, title, `description`, lesson_type, lesson_week) VALUES ('8478d16b-46b8-482c-a67a-a19d5ff396be', 2, 'Lesson 2', 'This is a raiser lesson', 'raiser', 1);
INSERT INTO lesson (id, order_index, title, `description`, lesson_type, lesson_week) VALUES ('396840e0-0624-4915-a718-a374c5ab656e', 3, 'Lesson 3', 'This is a staff lesson', 'staff', 1);

/* Tasks dummy data */
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('684b53b9-61ce-4bf7-9849-39bf65c3c811', 1, '4b902cd9-059f-4159-acb5-0a714975aaf0', 'Task 1', 'This is a client task');
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('6ed00351-dfb4-4f07-90e5-661966029f57', 2, '8478d16b-46b8-482c-a67a-a19d5ff396be', 'Task 2', 'This is a raiser task');
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('ac497f17-5a67-45e1-b497-683918f16d23', 3, '396840e0-0624-4915-a718-a374c5ab656e', 'Task 3', 'This is a staff task');

/* Screens dummy data */
INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('5d742fd9-3e60-47ad-9944-abe3412dcba7', 1,'Screen 1', '684b53b9-61ce-4bf7-9849-39bf65c3c811', 'This is a client screen', 'https://www.pawswithacause.org/wp-content/themes/paws/graphics/header-logo.png', 'https://www.youtube.com/watch?v=uRF9HLpTDyE', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('7b7760bb-21c1-4dd6-9f88-0d453d4f1248', 2, 'Screen 2', '684b53b9-61ce-4bf7-9849-39bf65c3c811', 'This is a client screen', true);

INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('a8003e11-b3c0-4d1c-a57d-af33d089981c', 4, 'Screen 1', '6ed00351-dfb4-4f07-90e5-661966029f57', 'This is a raiser screen', 'https://www.pawswithacause.org/wp-content/themes/paws/graphics/header-logo.png', 'https://www.youtube.com/watch?v=uRF9HLpTDyE', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('ef4f1800-648f-4770-8903-892274c6e1d6', 3, 'Screen 2', '6ed00351-dfb4-4f07-90e5-661966029f57', 'This is a raiser screen', true);

INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('39dfb5e8-ea73-4b49-b0cf-dbc6dd8cd4b1', 5, 'Screen 1', 'ac497f17-5a67-45e1-b497-683918f16d23', 'This is a staff screen', 'https://www.pawswithacause.org/wp-content/themes/paws/graphics/header-logo.png', 'https://www.youtube.com/watch?v=uRF9HLpTDyE', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('e5f70128-abde-48ae-a3a5-24bb817a1e04', 6, 'Screen 2', 'ac497f17-5a67-45e1-b497-683918f16d23', 'This is a staff screen', true);

