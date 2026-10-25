Draw It or Lose It Software Design Document

This repository holds the completed software design document I wrote for The Gaming Room (`CS_230_Project_Software_Design_Document.docx`), along with the Java prototype code from Project One.

## Reflection

### Briefly summarize The Gaming Room client and their software requirements.

The client was The Gaming Room, a company that offers *Draw It or Lose It*, a team guessing game where stock drawings render on screen as clues. The game existed only as an Android app, and the company wanted a web-based version that serves multiple platforms without a separate native app for each one. Teams play four one-minute rounds, each drawing finishes rendering at 30 seconds, and if a team does not solve the puzzle, every remaining team gets one 15-second guess. As a consultant at Creative Technology Solutions, I designed a web-based, distributed Java application. A game can have one or more teams, each team has multiple players, names must be unique, and only one game service can exist in memory at a time.

### What did you do particularly well in developing this documentation?

I think I did best at tying each decision back to a reason the client could follow. The design document explains why the game service is a singleton, why the iterator pattern is used to keep names unique, and where that design stops working (for example, when more than one server is needed). The Recommendations section does the same for the operating platform. I compared Linux, Windows, and Mac for hosting, recommended Linux in the cloud, and covered storage, memory, networking, and security with specific details such as image sizes, a topology diagram, and a platform comparison table. I also drew on my work as an automation engineer, where I have used Red Hat servers and Windows-based PLC tools, to judge real-world tradeoffs such as paid support versus free distributions.

### What about the process of working through a design document did you find helpful when developing the code?

Writing the design constraints before and alongside the code showed me problems I would have missed otherwise. Working through uniqueness rules forced me to decide that names are compared exactly, that team names are unique within a game, and that player names are unique within a team. Thinking about shared state also made me see that the singleton only guarantees one instance per running server, so thread safety and persistent storage would be needed before launch. Having the domain model written down also kept `Entity`, `Game`, `Team`, `Player`, and `GameService` consistent as I built them.

### If you could choose one part of your work on these documents to revise, what would you pick? How would you improve it?

I would revise the Evaluation and System Architecture View sections of the design document. My platform evaluation lives in a separate Project Two document, so the final design document does not contain it. I would bring that evaluation into the main document and add a logical architecture view that covers the physical tiers as well as communication and storage. That would make the document complete on its own, instead of making a reader open several files.

### How did you interpret the user's needs and implement them into your software design? Why is it so important to consider the user's needs when designing?

I read the client's needs in two layers. The explicit requirements (teams, players, unique names, a single service instance) became the domain model and the singleton and iterator patterns. The implied needs, such as playing on many devices, fair timing, and the fact that their staff did not know how to set up the environment, shaped the platform recommendation and the choice of web standards, a server that owns the official clock, and a container-friendly Linux host. Because some players may be children, I also treated privacy and security as must-haves. Considering the user's needs matters because a design that is technically correct but does not fit how the client and their players actually work will not get used, and fixing that after launch costs far more than fixing it in the design.

### How did you approach designing software? What techniques or strategies would you use in the future to analyze and design a similar software application?

I started from the requirements, modeled the domain, and then chose patterns that matched specific problems. I wrote down constraints and open questions (such as storage and scaling) early instead of hiding them. Next time I would do the same, and I would also estimate capacity numbers earlier, such as concurrent players and storage, build a quick threat model for security, and test the design against a prototype before committing to the architecture. I would keep using UML diagrams, comparison tables, and a topology diagram, because they make a design easier for both clients and developers to review.
