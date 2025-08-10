# Anemic Domain Model

What you sometimes see happening in software is that the state and the 'behavior' of an object are spread across multiple classes.
In this kata, you see that the state of a Hotel is in the Hotel object, but the behavior of Hotel is in a HotelManager.

The disadvantages of such a setup are:
- The state must be readable (public getters) because the HotelManager needs it.
- The state must also be writable (public setters) because the HotelManager needs to modify Hotel data.
- You risk unnecessary extra complexity, as nothing dictates where the business logic belongs. This can lead to business logic being spread across multiple classes.

This phenomenon is also known as an ['Anemic Domain Model'](https://en.wikipedia.org/wiki/Anemic_domain_model), an anti-pattern where domain objects are reduced to data containers and contain no business logic.

Ideally, you want to combine state and behavior in your domain object. The advantages of this are:
- You can fully encapsulate state, so no more public getters and setters are needed.
- You can place business logic directly in the domain object, making it clearer where the logic belongs and what the responsibilities are.
- You can better test/maintain/extend state and behavior, because they are together in one object.
- Technical bonus: In this kata, Hotel can eventually become a record, for less boilerplate code and immutability by default.

With these improvements, you move more towards a ['Rich Domain Model'](https://medium.com/@aboutcoding/rich-domain-models-22f176ad6f1b), where domain objects contain both state and behavior.


# Assignment

Combine the data from Hotel and the business logic from HotelManager into a single class.

**Extra challenge**: Try to make as few manual changes as possible, but use IntelliJ's built-in refactor methods, such as: 'Convert to Instance Method' and 'Move Members' (F6)

