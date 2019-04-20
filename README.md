# pwndpassword

[![Clojars Project](https://img.shields.io/clojars/v/pwndpassword.svg)](https://clojars.org/pwndpassword)

Tests if a given password has been pwned using the haveibeenpwned.com API.

Inspired by this node.js implementation [here](https://github.com/jamiebuilds/havetheybeenpwned)


## Add to project

### Leiningen/Boot

Add
```clojure
[pwndpassword "0.1.0-SNAPSHOT"]
```
to your dependencies


## Usage

import the package into your project and then use the `pwnd` function

```clojure
(ns yournamespace
  (:require [pwndpassword :refer [pwnd?]]))

(pwnd? "passwordtocheck") ; returns true or false
```