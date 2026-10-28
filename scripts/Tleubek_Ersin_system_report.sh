#!/bin/bash

PROJECT_DIR="$(cd "$(dirname "$0")/.." && pwd)"
LOG_FILE="$PROJECT_DIR/logs/Tleubek_Ersin_system_report.log"

{
    echo "===================================="
    echo "Student: Yersin Tleubek"
    echo "Date and time: $(date)"
    echo "Username: $(whoami)"
    echo
    echo "Operating system:"
    grep PRETTY_NAME /etc/os-release | cut -d'"' -f2
    echo
    echo "Kernel version:"
    uname -r
    echo
    echo "CPU information:"
    lscpu | head -n 10
    echo
    echo "Memory information:"
    free -h
    echo
    echo "Disk usage:"
    df -h
    echo
    echo "Available disk space:"
    df -h /
    echo "===================================="
} | tee "$LOG_FILE"
