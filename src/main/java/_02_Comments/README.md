# Comments

Sometimes you should ask yourself whether comments in code are being used properly, because comments can (unintentionally) try to hide code smells.
Comments are sometimes used to prevent/solve other problems that should actually be fixed with a small refactor.

Comments can sometimes be replaced with:
- Better variable names
- Better method names
- Simply removing them, comments are superfluous (explain the obvious) or it's code in comments
- A new utility method

```java
    int sum(int a, int b){
        // Adds a and b together --> SUPERFLUOUS
        return a + b;
    }
```

An easy check I ask myself when writing comments: ```Does this comment add value, and is it not trying to hide something?```

Of course, there are still good reasons to write comments:
- JavaDoc
- Decisions that cannot be derived from code

# Assignment

Review the comments in ```Container.java``` and refactor where necessary, considering the examples above.

**Extra challenge**: Try to make as few manual changes as possible, but use IntelliJ's built-in refactor methods, such as 'Rename Variable' (۩ + F6) and 'Change Signature' (⌘ + F6).

