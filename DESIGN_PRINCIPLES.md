# Xeronote Design Principles

* Document principles and ideas: connect code to documented ideas; keep these connections up-to-date and accurate
* Use dependency injection for inversion of control;
* Write for future extensibility;
* Write to interfaces: configure implementations;
* Modularize: loosely couple interface(s) with core functionality; Make it possible to drop in/configure other interfaces;
* Where feasible, favor immutable data;
* Text/copy intended for user consumption is configuration, and it should be extracted into configuration files;
* Git commit logs should summarize the work that has been done (using present-tense verbs such as "wire up the database") and include any relevant description of the state as of the commit.
* Normalizing rule: if a class constructor requires more than 4 arguments, consider whether the class needs to be refactored: maybe the class is doing more than one thing; perhaps one should use a builder class.