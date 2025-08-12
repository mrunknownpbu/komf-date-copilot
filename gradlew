#!/usr/bin/env sh

# Gradle wrapper script
# This script is used to invoke the Gradle wrapper.

set -e

DIR="$(cd "$(dirname "$0")" && pwd)"
if [ -z "$GRADLE_HOME" ]; then
  GRADLE_HOME="$DIR/gradle/wrapper/gradle-wrapper.properties"
fi

if [ -f "$GRADLE_HOME" ]; then
  exec "$DIR/gradle/wrapper/gradle" "$@"
else
  echo "Gradle wrapper not found. Please ensure that the gradle-wrapper.properties file exists."
  exit 1
fi