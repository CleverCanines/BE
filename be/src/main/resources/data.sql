/* Dummy data for testing and development */

/* Adding User data =================================================================================================================== */
INSERT INTO person (id, username, dog_name, `role`) VALUES ('66249183-c8a3-4482-a65b-0947aac07369', 'testingClient', 'dog1', 'client');
INSERT INTO person (id, username, dog_name, `role`) VALUES ('a2b9d0cf-40f4-4f72-8d10-b3450e7025d6', 'testingRaiser', 'dog2', 'raiser');
INSERT INTO person (id, username, `role`) VALUES ('67ab9a75-aae9-4242-a455-51df0bcd0422', 'testingStaff', 'staff');

/* Lessons dummy data ================================================================================================================= */

/* Lessons for client */
INSERT INTO lesson (id, order_index, title, `description`, lesson_type, lesson_week) VALUES ('1d13aea6-1d77-4b9e-bffb-12fbfe3bcc91', 0, 'Information', '', 'client', 1);
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('8baf976d-a6ad-48c0-8e93-21936b188398', 1, '1d13aea6-1d77-4b9e-bffb-12fbfe3bcc91', 'Prep', '');
INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, only_instruction) VALUES ('82e82d43-9afa-451a-b301-7e6141021816', 1,'Food', '8baf976d-a6ad-48c0-8e93-21936b188398', 'Here is information about what food you should buy:\n\nHere is an image of the recommended food type ', 'https://assets.petco.com/petco/image/upload/f_auto,q_auto/3884665-center-1', false);



/* Lessons for raiser */
INSERT INTO lesson (id, order_index, title, `description`, lesson_type, lesson_week) VALUES ('4b902cd9-059f-4159-acb5-0a714975aaf0', 0, 'Information', '', 'raiser', 1);
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('684b53b9-61ce-4bf7-9849-39bf65c3c811', 1, '4b902cd9-059f-4159-acb5-0a714975aaf0', 'Prep', '');
INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, only_instruction) VALUES ('5d742fd9-3e60-47ad-9944-abe3412dcba7', 1,'Food', '684b53b9-61ce-4bf7-9849-39bf65c3c811', 'Here is information about what food you should buy:\n\nHere is an image of the recommended food type ', 'https://assets.petco.com/petco/image/upload/f_auto,q_auto/3884665-center-1', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, only_instruction) VALUES ('a5077656-afd6-430b-808c-099e0c8f1be8', 2,'Toys', '684b53b9-61ce-4bf7-9849-39bf65c3c811', 'Here is information about what toys you should buy:\n\nHere is an image of the recommended toy type ', 'https://i5.walmartimages.com/seo/Nylabone-Gourmet-Style-Nylon-Strong-Wishbone-Dog-Chew-Toy-Peanut-Butter-Large-Giant-up-to-50-lbs_313abae8-de01-46bd-b08e-a4f390305e80.2b1a3e304a2121fede9f0f02a7206d5d.jpeg', false);
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('82669719-af6d-4c46-9e28-1b16a4bf3807', 2, '4b902cd9-059f-4159-acb5-0a714975aaf0', 'Puppy class', '');
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('e40ebe67-1c15-461f-95dd-65dd87f643f9', 1,'What is puppy class?', '82669719-af6d-4c46-9e28-1b16a4bf3807', 'Here is information about puppy class:\n\nblah blah blah insert stuff here', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('8814fa2a-a90b-4780-a6b8-78a81ca069ae', 2,'How often should I go?', '82669719-af6d-4c46-9e28-1b16a4bf3807', 'Here is information about puppy class times:\n\nblah blah blah insert stuff here\n\nEVERY WEEK!', false);
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('2be81944-4940-4bf9-adf1-c578335d0daa', 3, '4b902cd9-059f-4159-acb5-0a714975aaf0', 'This app', '');
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('4464f431-273b-488a-9606-e9f9a3db828a', 1,'What is this app?', '2be81944-4940-4bf9-adf1-c578335d0daa', 'Here is information about this app:\n\nblah blah blah insert stuff here', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('cc7715b3-1820-445d-b667-14143015c864', 2,'How to use this app', '2be81944-4940-4bf9-adf1-c578335d0daa', 'Here is information about how to use this app:\n\nblah blah blah insert stuff here', false);

INSERT INTO lesson (id, order_index, title, `description`, lesson_type, lesson_week) VALUES ('b498900f-faff-43ea-a413-dbd6aac9073d', 0, 'Basic', '', 'raiser', 1);
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('5b47e452-8eb3-46b5-bc22-f462b2e2d519', 1, 'b498900f-faff-43ea-a413-dbd6aac9073d', 'Naming', '');
INSERT INTO screen (id, order_index, title, task_id, `text`, video_url, only_instruction) VALUES ('49616e70-c74e-429e-8726-0cb170b71387', 1,'What should I name my dog?', '5b47e452-8eb3-46b5-bc22-f462b2e2d519', 'Here is information about what you should teach your dog their name your dog:\n\nblah blah blah insert stuff here', 'https://www.youtube.com/embed/uRF9HLpTDyE?si=lJaNxQ39Cli6JtzY', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('f1bbd554-3832-43a3-a8b7-e5151546d90b', 2,'Practice!', '5b47e452-8eb3-46b5-bc22-f462b2e2d519', 'Practice the exercise explained with your dog until you can get there attention with their name', false);
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('aeba2aa0-7f0b-4b28-9baf-dd909d20d974', 2, 'b498900f-faff-43ea-a413-dbd6aac9073d', 'Using Yes/No', '');
INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('779e31ff-af86-454d-a32f-1a4ff1db42fc', 1,'What is Yes/No?', 'aeba2aa0-7f0b-4b28-9baf-dd909d20d974', 'Here is information about what you should teach your dog with Yes/No:\n\nblah blah blah insert stuff here', 'https://www.wikihow.com/images/thumb/a/ab/Tell-Your-Dog-No-Step-1-Version-3.jpg/v4-460px-Tell-Your-Dog-No-Step-1-Version-3.jpg.webp', 'https://www.youtube.com/embed/uRF9HLpTDyE?si=lJaNxQ39Cli6JtzY', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('e9dad28f-645f-4617-95ec-b665c03fb29e', 2,'Practice!', 'aeba2aa0-7f0b-4b28-9baf-dd909d20d974', 'Practice the exercise explained with your dog until...', false);

INSERT INTO lesson (id, order_index, title, `description`, lesson_type, lesson_week) VALUES ('bc443d44-e52b-4645-8ba6-5655fc90ecdc', 0, 'Sit and Down', '', 'raiser', 2);
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('d34bb2b7-d037-43af-877c-b9577c2308de', 1, 'bc443d44-e52b-4645-8ba6-5655fc90ecdc', 'Sit', '');
INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('bc0b50d1-0e2c-40b8-b80f-f55e0505bb4c', 1,'What is Sit?', 'd34bb2b7-d037-43af-877c-b9577c2308de', 'Here is information about what you should teach your dog with Sit:\n\nblah blah blah insert stuff here', 'https://www.wikihow.com/images/thumb/3/39/Teach-Your-Dog-Basic-Commands-Step-1-Version-2.jpg/v4-460px-Teach-Your-Dog-Basic-Commands-Step-1-Version-2.jpg.webp', 'https://www.youtube.com/embed/uRF9HLpTDyE?si=lJaNxQ39Cli6JtzY', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('d50670da-26fd-4958-aed6-e497ed7265bc', 2,'Practice!', 'd34bb2b7-d037-43af-877c-b9577c2308de', 'Practice the exercise explained with your dog until...', false);
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('0baf961c-11c8-4cfd-985b-ccbf3dab0a49', 2, 'bc443d44-e52b-4645-8ba6-5655fc90ecdc', 'Down', '');
INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('4b546bb6-96dc-4ad7-b382-ac2d80ea16ae', 1,'What is Down?', '0baf961c-11c8-4cfd-985b-ccbf3dab0a49', 'Here is information about what you should teach your dog with Down:\n\nblah blah blah insert stuff here', 'https://media.graphassets.com/resize=height:360,width:1280/output=format:webp/i8clJDCKQ6KZvoK1hh7j?width=1280', 'https://www.youtube.com/embed/uRF9HLpTDyE?si=lJaNxQ39Cli6JtzY', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('addc07cd-45f6-40cd-9163-28133a7531a2', 2,'Practice!', '0baf961c-11c8-4cfd-985b-ccbf3dab0a49', 'Practice the exercise explained with your dog until...', false);
INSERT INTO task (id, order_index, lesson_id, title, `description`) VALUES ('3c86c52b-0f13-4402-919f-c4228fbc61fc', 3, 'bc443d44-e52b-4645-8ba6-5655fc90ecdc', 'Dog Push Ups', '');
INSERT INTO screen (id, order_index, title, task_id, `text`, image_url, video_url, only_instruction) VALUES ('eaba30cc-a7cc-412c-aedc-d24850575876', 1,'What is Dog Push Ups?', '3c86c52b-0f13-4402-919f-c4228fbc61fc', 'Here is information about what you should teach your dog with Dog Push Ups:\n\nblah blah blah insert stuff here', 'https://static.strengthlevel.com/images/exercises/push-ups/push-ups-800.jpg', 'https://www.youtube.com/embed/uRF9HLpTDyE?si=lJaNxQ39Cli6JtzY', false);
INSERT INTO screen (id, order_index, title, task_id, `text`, only_instruction) VALUES ('2676c121-0704-409a-9dfd-3636ee1ddd4a', 2,'Practice!', '3c86c52b-0f13-4402-919f-c4228fbc61fc', 'Practice the exercise explained with your dog until...', false);

