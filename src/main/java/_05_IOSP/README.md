# IOSP
When reading code, you create a mental model of how the code works. There are a few things that can make this harder, one such thing is a mixture of Operation and Integration code.
Suddenly the code you are reading is not only doing calculations, but also calling other parts of the system, interweaving the two. This is detrimental to understanding the code, because it is becoming harder and harder to follow the flow of the code.

IOSP is a clean code principle designed to tackle this problem. IOSP stands for Integration Operation Separation Principle. It states that code should be separated into two parts: the integration code and the operation code. 
- The integration code is responsible for calling other parts of the system.
- The operation code is responsible for the calculations and logic.

Splitting the code into these two parts makes it easier to read and understand, as the purpose of a method becomes clearer. 

In the example kata 'UserManager', the two types of code are mixed together, making what should be an extremely simple class much harder to read. 

# Assignment

Refactor the UserManager class so that the integration code is separated from the operation code.

**Extra challenge**: Make use of IntelliJ's built-in refactor methods, such as 'Extract Method' (⌥⌘M) 
