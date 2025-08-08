# Avoid returning null
When methods have no value to return, sometimes `null` is returned.
However, this causes problems, because the calling code then has to check whether the value is `null` before it can be used.

So introducing a `return null` seeps through into the rest of the code.
Additionally, it is error-prone: if someone forgets to check for `null` and still uses the value, this can lead to a `NullPointerException`.

Instead, it is often* better to use one of the following options:
- Return an empty collection, such as an empty list or set.
- Return an optional value, such as `Optional<T>`.
- Return a default value, such as an empty string or a default value for a primitive type.


\* The reason I say often is because `null` sometimes has functional meaning, such as a choice that has not yet been made.
If you return a default value, how do you distinguish that no choice has been made?


# Assignment

Refactor Item and ItemRepository so that all null checks and returns are removed. Note that some unit tests might require small adjustments.

Try to use the following techniques:
- Optional<T>
- Empty collections
- Default values
- 
