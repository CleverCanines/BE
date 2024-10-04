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

/* Additional Lessons dummy data */
INSERT INTO lesson (id, order_index, title, `description`, lesson_type, lesson_week) VALUES ('d1a2b3c4-1234-5678-9101-112131415161', 1, 'Lesson 4', 'This is a client lesson', 'client', 2);
INSERT INTO lesson (id, order_index, title, `description`, lesson_type, lesson_week) VALUES ('e2b3c4d5-2345-6789-1011-121314151617', 2, 'Lesson 5', 'This is a raiser lesson', 'raiser', 2);
INSERT INTO lesson (id, order_index, title, `description`, lesson_type, lesson_week) VALUES ('f3c4d5e6-3456-7890-1121-314151617181', 3, 'Lesson 6', 'This is a staff lesson', 'staff', 2);

/* Additional Tasks dummy data */
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('7ffdab58-933d-4229-a3d4-3ce32eedee4b ', 1, 'd1a2b3c4-1234-5678-9101-112131415161', 'Task 4', 'This is a client task');
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('f9626cd0-c9b9-49fc-b766-84eb89252db5', 2, 'd1a2b3c4-1234-5678-9101-112131415161', 'Task 5', 'This is a client task');
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('8cde1ba5-e4ef-4289-9e34-30ba8cc18ec2', 1, 'e2b3c4d5-2345-6789-1011-121314151617', 'Task 6', 'This is a raiser task');
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('6ad1ee4c-a03a-4056-9371-284dbbde4a90', 2, 'e2b3c4d5-2345-6789-1011-121314151617', 'Task 7', 'This is a raiser task');
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('1eb0cc98-3d6c-4163-977c-4aa13b5c3174', 1, 'f3c4d5e6-3456-7890-1121-314151617181', 'Task 8', 'This is a staff task');
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('678c2f6c-5f73-4264-9755-397e3d415c33', 2, 'f3c4d5e6-3456-7890-1121-314151617181', 'Task 9', 'This is a staff task');

/* Additional Screens dummy data */
INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('c28da8cf-7b59-4909-a686-f3ea6b42527d', 1, 'Screen 3', '7ffdab58-933d-4229-a3d4-3ce32eedee4b ', 'This is a client screen', 'https://www.pawswithacause.org/wp-content/themes/paws/graphics/header-logo.png', 'https://www.youtube.com/watch?v=uRF9HLpTDyE', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('a9564ea2-a438-4476-9643-c8c409a2006d', 2, 'Screen 4', '7ffdab58-933d-4229-a3d4-3ce32eedee4b ', 'This is a client screen', true);

INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('e03e313b-9e6b-4e43-b41c-e1da3a7ac893', 3, 'Screen 3', 'f9626cd0-c9b9-49fc-b766-84eb89252db5', 'This is a client screen', 'https://www.pawswithacause.org/wp-content/themes/paws/graphics/header-logo.png', 'https://www.youtube.com/watch?v=uRF9HLpTDyE', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('d184b5de-0479-4976-8bea-6e1085b60f0a', 4, 'Screen 4', 'f9626cd0-c9b9-49fc-b766-84eb89252db5', 'This is a client screen', true);

INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('4290d3b9-1072-4078-94e0-b84567d2a4bf', 5, 'Screen 3', '8cde1ba5-e4ef-4289-9e34-30ba8cc18ec2', 'This is a raiser screen', 'https://www.pawswithacause.org/wp-content/themes/paws/graphics/header-logo.png', 'https://www.youtube.com/watch?v=uRF9HLpTDyE', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('83f8b78f-e777-4e20-8d4c-b06afa4306c2', 6, 'Screen 4', '8cde1ba5-e4ef-4289-9e34-30ba8cc18ec2', 'This is a raiser screen', true);

INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('fdb06f93-7dad-4f8e-a662-55296a24a2dc', 7, 'Screen 3', '6ad1ee4c-a03a-4056-9371-284dbbde4a90', 'This is a raiser screen', 'https://www.pawswithacause.org/wp-content/themes/paws/graphics/header-logo.png', 'https://www.youtube.com/watch?v=uRF9HLpTDyE', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('7f23f0f2-104c-4e84-97f0-cb01c2ee547c', 8, 'Screen 4', '6ad1ee4c-a03a-4056-9371-284dbbde4a90', 'This is a raiser screen', true);

INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('70cc1fbc-2f94-49c7-b2a5-1b081034f5a2', 9, 'Screen 3', '1eb0cc98-3d6c-4163-977c-4aa13b5c3174', 'This is a staff screen', 'https://www.pawswithacause.org/wp-content/themes/paws/graphics/header-logo.png', 'https://www.youtube.com/watch?v=uRF9HLpTDyE', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('b473ecde-3a58-48fd-9809-bb114462e3e8', 10, 'Screen 4', '1eb0cc98-3d6c-4163-977c-4aa13b5c3174', 'This is a staff screen', true);

INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('58a6253c-7250-4bb0-9bbb-575d707fbea0', 11, 'Screen 3', '678c2f6c-5f73-4264-9755-397e3d415c33', 'This is a staff screen', 'https://www.pawswithacause.org/wp-content/themes/paws/graphics/header-logo.png', 'https://www.youtube.com/watch?v=uRF9HLpTDyE', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('088fade5-6510-48bb-8538-331d24a2ec85', 12, 'Screen 4', '678c2f6c-5f73-4264-9755-397e3d415c33', 'This is a staff screen', true);