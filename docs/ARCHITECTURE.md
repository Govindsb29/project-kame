# Project Kame Architecture

## Goal

Project Kame is a native desktop companion for Mihon.

The application will:

- Import Mihon backups
- Display the user's library
- Read manga/manhwa
- Synchronize reading progress
- Preserve the Mihon experience

---

## Current Pipeline

.tachibk
↓
BackupReader
↓
BackupInspector
↓
GzipBackupReader
↓
Protobuf Data

---

## Completed

- Read backup file
- Detect GZIP
- Decompress backup
- Inspect backup contents

---

## Next Milestone

Parse the protobuf backup into structured Java objects.