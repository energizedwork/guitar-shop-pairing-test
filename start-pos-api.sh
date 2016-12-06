#!/bin/bash

pushd pos-api
java -jar wiremock-standalone-2.2.2.jar --port 8000
popd