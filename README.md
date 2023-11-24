# Project Gitmem

(I haven't thought of a good name for this project yet.)

## Idea

The idea is a utility to keep track of notes (that is: notes like flashcards used for the sake of learning something) that does the following according to the following contraints:
* It  manages but does not store the notes: the notes are stored independently as text files, probably markdown files. Think of how Git manages metadata about files but does not edit or store them.
* It maintains at least the following metadata: date of creation of file, dates when the file has been reviewed.
* It computes, based on existing metadata, when a note needs to be reviewed next.
* At any particular time, it can provide a list of *which* notes need to be reviewed.

## Additional Considerations

* The easiest place to start will be a command-line utility. I intend to write the core of the program in such a way that it can later be hooked up to a GUI if I or someone else wants to write it.
* The data involved in performing the basic functionality aboved will require the sophistication of a relational database. I'm envisioning maybe an in-memory database.
* I will use Spring Boot and perhaps H2 and Hibernate for the database interactivity. I think it will be slow and big, but my goal right now is to practice those frameworks/libraries. If the software itself proves interesting and/or useful enough to justify itself, *then* I might think about possibilities for streamlining it and making it faster.

## Relevant Other Software

Existing software that might be useful either for inspiration or for open source code:
* Git
* Mnemosyne
* Zettlr

## Theory

This utility lends itself to studying using a specific kind of what you might call a technique or even an architecture. It's related to the idea of a zettelkasten. In that sense, the utility itself is _opinionated_. It calls for documentation on technique, not just on the basic mechanics of using the utility.

## Design Principles
See the DESIGN_PRINCIPLES.md file.
