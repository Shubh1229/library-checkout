-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;


INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('91a50d7d-ec7d-40f8-908d-add3b08dd5ae', 15, 223, DATE '1997-06-26', 'J.K. Rowling', 'Fantasy', 'Bloomsbury', 'Summary of Harry Potter and the Philosopher''s Stone', 'Harry Potter and the Philosopher''s Stone', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('cb186dfa-ff02-4fd3-98be-17b425d9d2db', 5, 310, DATE '1937-09-21', 'J.R.R. Tolkien', 'Fantasy', 'George Allen & Unwin', 'Summary of The Hobbit', 'The Hobbit', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('2d3fe416-c218-47fa-9b2e-799b6d275bf2', 11, 328, DATE '1949-06-08', 'George Orwell', 'Dystopian', 'Secker & Warburg', 'Summary of 1984', '1984', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('1fc8ea8d-e301-4f42-8b52-491630938523', 4, 277, DATE '1951-07-16', 'J.D. Salinger', 'Fiction', 'Little, Brown and Company', 'Summary of The Catcher in the Rye', 'The Catcher in the Rye', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('aca8e530-2973-4077-b5dc-dd223a178f46', 17, 281, DATE '1960-07-11', 'Harper Lee', 'Southern Gothic', 'J.B. Lippincott & Co.', 'Summary of To Kill a Mockingbird', 'To Kill a Mockingbird', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('64f6caed-1c4d-432f-a6d3-0f65d7dd75bb', 6, 279, DATE '1813-01-28', 'Jane Austen', 'Romance', 'T. Egerton', 'Summary of Pride and Prejudice', 'Pride and Prejudice', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('7c9f68ef-3036-4735-a6b3-69a54475966c', 14, 180, DATE '1925-04-10', 'F. Scott Fitzgerald', 'Tragedy', 'Charles Scribner''s Sons', 'Summary of The Great Gatsby', 'The Great Gatsby', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('1cb6ac39-34c0-40dd-81c3-58b5a4870934', 13, 635, DATE '1851-10-18', 'Herman Melville', 'Adventure', 'Harper & Brothers', 'Summary of Moby-Dick', 'Moby-Dick', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('e6487f4a-5498-4947-b697-7ac29ef8e806', 9, 311, DATE '1932-08-30', 'Aldous Huxley', 'Science Fiction', 'Chatto & Windus', 'Summary of Brave New World', 'Brave New World', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('0e9e660a-1ae7-4cd7-98a3-77501cd48303', 18, 1178, DATE '1954-07-29', 'J.R.R. Tolkien', 'Fantasy', 'George Allen & Unwin', 'Summary of The Lord of the Rings', 'The Lord of the Rings', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('2e695755-4c47-4f06-ba03-c143907bf98f', 10, 500, DATE '1847-10-16', 'Charlotte Brontë', 'Romance', 'Smith, Elder & Co.', 'Summary of Jane Eyre', 'Jane Eyre', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('99cdd43e-b8c6-468b-88f1-5d23a6342a11', 16, 416, DATE '1847-12-01', 'Emily Brontë', 'Tragedy', 'Thomas Cautley Newby', 'Summary of Wuthering Heights', 'Wuthering Heights', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('f27868c1-f9f1-4fa4-9bca-64c153ed7a23', 3, 430, DATE '1866-01-01', 'Fyodor Dostoevsky', 'Philosophical Fiction', 'The Russian Messenger', 'Summary of Crime and Punishment', 'Crime and Punishment', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('a3c60c5b-d36b-430d-97c5-8cb70c9ebc1a', 11, 1225, DATE '1869-01-01', 'Leo Tolstoy', 'Historical', 'The Russian Messenger', 'Summary of War and Peace', 'War and Peace', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('4a25ed2e-6dce-402b-833f-c82aaaff8d88', 7, 864, DATE '1878-01-01', 'Leo Tolstoy', 'Realist Fiction', 'The Russian Messenger', 'Summary of Anna Karenina', 'Anna Karenina', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('bd511cc1-5c53-4411-9524-be288b6af2d1', 6, 796, DATE '1880-11-01', 'Fyodor Dostoevsky', 'Philosophical Fiction', 'The Russian Messenger', 'Summary of The Brothers Karamazov', 'The Brothers Karamazov', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('cf6537ae-cb97-4666-9bb5-26b70ba63f95', 19, 280, DATE '1818-01-01', 'Mary Shelley', 'Horror', 'Lackington, Hughes, Harding, Mavor & Jones', 'Summary of Frankenstein', 'Frankenstein', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('5b59ced9-0a48-4846-af5f-3af2879dd53d', 14, 418, DATE '1897-05-26', 'Bram Stoker', 'Horror', 'Archibald Constable and Company', 'Summary of Dracula', 'Dracula', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('0572dbb0-79c9-47e2-8e76-2f6dc85d5693', 5, 254, DATE '1890-06-20', 'Oscar Wilde', 'Philosophical Fiction', 'Ward, Lock & Co.', 'Summary of The Picture of Dorian Gray', 'The Picture of Dorian Gray', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('82477f87-2a3a-432f-b5a0-0f8a0f8ff980', 12, 123, DATE '1942-04-01', 'Albert Camus', 'Existential', 'Gallimard', 'Summary of The Stranger', 'The Stranger', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('18890948-4310-45b3-a6cd-5f9e108eabcb', 20, 863, DATE '1605-01-16', 'Miguel de Cervantes', 'Satire', 'Francisco de Robles', 'Summary of Don Quixote', 'Don Quixote', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('dc3abb1c-956d-4897-ba0d-e9b4b27a0349', 9, 798, DATE '1320-01-01', 'Dante Alighieri', 'Epic Poetry', 'Various', 'Summary of The Divine Comedy', 'The Divine Comedy', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('8b9f6a80-4631-43e6-9483-b14197a8c0af', 8, 1463, DATE '1862-01-01', 'Victor Hugo', 'Historical Fiction', 'A. Lacroix, Verboeckhoven & Cie.', 'Summary of Les Misérables', 'Les Misérables', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('bc4e133f-d991-4b96-b486-c6e80e626fe3', 17, 208, DATE '1988-04-01', 'Paulo Coelho', 'Adventure', 'HarperTorch', 'Summary of The Alchemist', 'The Alchemist', NULL);

INSERT INTO Books (id, bookquantity, pagenumbers, publicationdate, author, genre, publisher, summary, title, booksisbn)
VALUES ('e9cfaacc-1cc3-43f9-beab-fc14595cf645', 3, 371, DATE '2003-05-29', 'Khaled Hosseini', 'Drama', 'Riverhead Books', 'Summary of The Kite Runner', 'The Kite Runner', NULL);


INSERT INTO CheckedOutBooks (bookid, refid, checkoutDate, dueDate)
VALUES ('91a50d7d-ec7d-40f8-908d-add3b08dd5be', '91a50d7d-ec7d-40f8-908d-add3b08dd5ae', DATE '2025-06-24', DATE '2025-07-01');