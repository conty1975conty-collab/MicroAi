#!/usr/bin/env bash
set -euo pipefail
# Usage: export ANDROID_KEYSTORE=<base64-keystore> ; ./scripts/decode-keystore.sh
if [ -z "${ANDROID_KEYSTORE:-}" ]; then
  echo "ANDROID_KEYSTORE env not set"
  exit 1
fi
echo "$ANDROID_KEYSTORE" | base64 --decode > "$HOME/keystore.jks"
echo "Keystore written to $HOME/keystore.jks"
