#!/bin/bash -l
cd "${0%/*}"
cd ../../seleniumCL
mvn test -P regressionTest
open ./extent.html