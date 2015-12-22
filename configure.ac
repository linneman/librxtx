#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ([2.61])
AC_INIT([librxtx], [2.2.2], [taj@www.linux.org.uk])
AM_INIT_AUTOMAKE
AC_CONFIG_MACRO_DIR([m4])
AC_CONFIG_SRCDIR([src/SerialImp.c])
AC_CONFIG_HEADERS([config.h])

# Checks for programs.
AC_PROG_CC

# Checks for libraries.

# Checks for header files.
AC_HEADER_DIRENT
AC_HEADER_STDC
AC_CHECK_HEADERS([stdlib.h string.h unistd.h signal.h sys/signal.h termios.h sys/fcntl.h pthread.h])

# Checks for typedefs, structures, and compiler characteristics.
AC_C_CONST
AC_HEADER_STDBOOL
AC_C_INLINE
AC_TYPE_SIZE_T
AC_HEADER_TIME

# Checks for library functions.
AC_FUNC_CLOSEDIR_VOID
AC_FUNC_MEMCMP
AC_FUNC_SELECT_ARGTYPES
AC_TYPE_SIGNAL
AC_FUNC_STAT
AC_PROG_LIBTOOL
AX_PROG_JAVA
AX_PROG_JAVAC
AX_PROG_JAVAH
AX_PROG_JAR
AX_CHECK_JAVA_HOME

# AC_CHECK_FUNCS([inet_ntoa memset socket])

AC_CHECK_LIB([pthread], [pthread_create])

AM_INIT_AUTOMAKE([subdir-objects -Wall])

AC_ARG_VAR([JDK_HOME], [root directory of Java Development Kit])
if test -z "$JDK_HOME"; then
   # assume as default JAVA_HOME
   JDK_HOME=${JAVA_HOME}
fi
AC_MSG_NOTICE([JDK_HOME=${JDK_HOME}])


AC_CONFIG_FILES([Makefile librxtxSerial.pc])

AC_OUTPUT
