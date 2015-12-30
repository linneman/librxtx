ACLOCAL_AMFLAGS = -I m4
JAVAC_FLAGS = -Xlint:unchecked -classpath $(CLASSPATH) -d $(TOP)/ -O
CLASSPATH = .:

lib_LTLIBRARIES=librxtxSerial.la # meta library name used by libtool
JARTARGET=RXTXcomm.jar # java archive file
jardir = $(libdir)
jar_DATA = $(JARTARGET)


AUTOMAKE_OPTIONS = foreign
TOP = $(top_srcdir)
SPATH = $(TOP)/src/

CLASSTOP=gnu
CLASSDIR=gnu.io
CLASSDEST=gnu/io
CLASSES = $(patsubst $(SPATH)/gnu/io/%.java,$(TOP)/$(CLASSDEST)/%.class,$(wildcard $(SPATH)/gnu/io/*.java))

javafiles = $(wildcard $(SPATH)/gnu/io/*.java)
javahfiles = $(patsubst $(SPATH)/gnu/io/%.java,%,$(javafiles))
javahdest="posix-gnu"

print-%  : ; @echo $* = $($*)


# generated sources
BUILT_SOURCES = $(CLASSES)
# Correctly clean the generated headers
CLEANFILES= $(BUILT_SOURCES) \
	$(TOP)/*.class $(TOP)/$(CLASSDEST)/*.class $(TOP)/$(JARTARGET)

EXTRA_DIST=$(javafiles) $(wildcard $(SPATH)/*.c) $(wildcard $(SPATH)/*.h) create_symlinks
# installed header files
# include_HEADERS=

# pkg config system
pkgconfigdir = $(libdir)/pkgconfig
pkgconfig_DATA = librxtxSerial.pc

# Preprocessor Flags
AM_CPPFLAGS = -Wall \
	-DNDEBUG -DLINUX -D_LARGEFILE64_SOURCE -D_GNU_SOURCE -D__need_timespec \
	-I$(TOP)/src -I$(TOP)/$(javahdest) \
	-I${JDK_HOME}/include/ \
	-I${JDK_HOME}/include/darwin/

AM_CFLAGS = -O2 -fpic -fno-omit-frame-pointer -fno-strict-aliasing -static-libgcc
librxtxSerial_la_LDFLAGS = -release $(VERSION) $(AM_LDFLAGS) -lpthread

# the rest of the sources goes into distribution (make dist)
librxtxSerial_la_SOURCES = \
	src/SerialImp.c \
	src/SerialImp.h

#  compile src/RXTXPort.java and similar files into classes
#  then create the .jar file
$(CLASSES): $(javafiles)
	$(JAVAC) $(JAVAC_FLAGS) $(javafiles)
	$(JAVAH) -classpath $(CLASSPATH) -d $(javahdest) -jni `(for i in $(javahfiles);do \
		if grep > /dev/null native.*\( $(SPATH)/gnu/io/$$i.java; then \
			echo $(CLASSDIR).$$i; \
		fi; \
	done)`
	$(JAR) cf $(JARTARGET) $(CLASSTOP)/*

install-exec-hook:
	./create_symlinks $(libdir) librxtxSerial.la $(JARTARGET)
