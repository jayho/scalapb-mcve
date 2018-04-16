# ScalaPB issue

MCVE illustrating a ScalaPB compilation failure when using definitions from [Google APIs](https://github.com/googleapis/googleapis)

~~## How to reproduce
Clone this repo and run `sbt compile`~~

## Fix
The provided [pull request](https://github.com/jchoffmann/scalapb-mcve/pull/1) demonstrates the correct plugin usage, which gets rid of the error.
