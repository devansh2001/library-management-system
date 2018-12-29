# library-management-system

This application is my first attempt at building a large-scale Java program. A lot of the programming practices I have used here are not
the best to use. However, I did this project before I took any formal college-level training in Computer Science or Java.

The application is a Library Management System. Users can create accounts, borrow books from stock, return books to stock, and donate extra
books to the library. Additionally, users can view the list of books available before borrowing.

All the data is stored in simple text files (.txt). To avoid confusion, all data stores is limited to its first 40 characters. Thus, every
field has a capacity of 40 characters and the program searches for data from the text files with this fact. A SQL database could be used in
place of the text file, but I did not use it here because I wanted to experiment with text files.
