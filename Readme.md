# Advent of Code 2021

This year I want to improve my kotlin skills. 
Explore new language feature, revisited concepts I already use, ...

What did I learn so far?

## Day 1

* project setup of a simple kotlin project
* `com.willowtreeapps.assertk:assertk-jvm:0.25` is the lib I use for unit tests all the time at work. Needed to import
  it.
* Array methods: `copyRanged` and `mapIndexed`

## Day 2

* I like `String#trimMargin()` to format input strings nicely in the tests.

## Day 3

* Feels like a dirty solution :) Probably should have used some kind of bitwise-operator or so.
* I liked the recursive part.

## Day 4

* `boardsLines.windowed(size = 6, step = 6)` is a nice way to "slide" over a list with a given window size
* Longest time was building the data structure for holding results and the boards.

## Day 5

* learnt what [Hydrothermal vents](https://de.wikipedia.org/wiki/Raucher_(Hydrothermie)) are
* Took time to read about the Ranges in kotlin and its different operators e.g. `..`, `until`, `downTo`, `step`
  - https://kotlinlang.org/docs/ranges.html