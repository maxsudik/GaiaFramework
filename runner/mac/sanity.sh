#!/bin/bash -l
cd "${0%/*}"
cd ../../seleniumCL
mvn test -P sanityTest
open ./extent.html
