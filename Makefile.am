ACLOCAL_AMFLAGS = -I m4
JAVAC_FLAGS = -Xlint:unchecked -classpath $(CLASSPATH) -d $(TOP)/ -O
CLASSPATH = .:

AUTOMAKE_OPTIONS = foreign
TOP = $(top_srcdir)
SPATH = $(TOP)/src/
DEST="linux-gnu"

CLASSTOP=gnu
CLASSDIR=gnu.io
CLASSDEST=gnu/io
JARTARGET=RXTXcomm.jar

CLASSES = $(patsubst $(SPATH)/%.java,$(TOP)/$(CLASSDEST)/%.class,$(wildcard $(SPATH)/*.java))
javafiles = $(wildcard $(SPATH)/*.java)
javahfiles = $(patsubst $(SPATH)/%.java,%,$(wildcard $(SPATH)/*.java))

print-%  : ; @echo $* = $($*)

# meta library name used by libtool
lib_LTLIBRARIES=librxtxSerial.la
jardir = $(libdir)
jar_DATA = $(JARTARGET)

# generated sources
BUILT_SOURCES = $(CLASSES)
# Correctly clean the generated headers
CLEANFILES= $(BUILT_SOURCES) \
	$(TOP)/*.class $(TOP)/$(CLASSDEST)/*.class $(TOP)/$(JARTARGET)

EXTRA_DIST=$(javafiles) $(wildcard $(SPATH)/*.c) $(wildcard $(SPATH)/*.h)
# installed header files
# include_HEADERS=

# pkg config system
pkgconfigdir = $(libdir)/pkgconfig
pkgconfig_DATA = librxtxSerial.pc

# Preprocessor Flags
AM_CPPFLAGS = -Wall \
	-DNDEBUG -DLINUX -D_LARGEFILE64_SOURCE -D_GNU_SOURCE -D__need_timespec \
	-I$(TOP)/src -I$(TOP)/$(DEST) \
	-I${JDK_HOME}/include/ \
	-I${JDK_HOME}/include/linux

AM_CFLAGS = -O2 -fpic -fno-omit-frame-pointer -fno-strict-aliasing -static-libgcc
librxtxSerial_la_LDFLAGS = $(AM_LDFLAGS) -lpthread

# the rest of the sources goes into distribution (make dist)
librxtxSerial_la_SOURCES = \
	src/fixup.c \
	src/init.c \
	src/portmode.c \
	src/SerialImp.c \
	src/SerialImp.h


# libsqlite4java_la_LDFLAGS = -version-info $(libtool_VERSION)

#  compile src/RXTXPort.java and similar files into classes
#  then create the .jar file
$(CLASSES): $(javafiles)
	javac $(JAVAC_FLAGS) $(javafiles)
	javah -classpath $(CLASSPATH) -d $(DEST) -jni `(for i in $(javahfiles);do \
		if grep > /dev/null native.*\( $(SPATH)/$$i.java; then \
			echo $(CLASSDIR).$$i; \
		fi; \
	done)`
	jar cf $(JARTARGET) $(CLASSTOP)/*
