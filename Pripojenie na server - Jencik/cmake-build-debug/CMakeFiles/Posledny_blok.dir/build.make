# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2020.3.3\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2020.3.3\bin\cmake\win\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = C:\Users\User\CLionProjects\Posledny_blok

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\Users\User\CLionProjects\Posledny_blok\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/Posledny_blok.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Posledny_blok.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Posledny_blok.dir/flags.make

CMakeFiles/Posledny_blok.dir/main.cpp.obj: CMakeFiles/Posledny_blok.dir/flags.make
CMakeFiles/Posledny_blok.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\User\CLionProjects\Posledny_blok\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/Posledny_blok.dir/main.cpp.obj"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\Posledny_blok.dir\main.cpp.obj -c C:\Users\User\CLionProjects\Posledny_blok\main.cpp

CMakeFiles/Posledny_blok.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Posledny_blok.dir/main.cpp.i"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\Users\User\CLionProjects\Posledny_blok\main.cpp > CMakeFiles\Posledny_blok.dir\main.cpp.i

CMakeFiles/Posledny_blok.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Posledny_blok.dir/main.cpp.s"
	C:\PROGRA~1\MINGW-~1\X86_64~1.0-P\mingw64\bin\G__~1.EXE $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S C:\Users\User\CLionProjects\Posledny_blok\main.cpp -o CMakeFiles\Posledny_blok.dir\main.cpp.s

# Object files for target Posledny_blok
Posledny_blok_OBJECTS = \
"CMakeFiles/Posledny_blok.dir/main.cpp.obj"

# External object files for target Posledny_blok
Posledny_blok_EXTERNAL_OBJECTS =

Posledny_blok.exe: CMakeFiles/Posledny_blok.dir/main.cpp.obj
Posledny_blok.exe: CMakeFiles/Posledny_blok.dir/build.make
Posledny_blok.exe: CMakeFiles/Posledny_blok.dir/linklibs.rsp
Posledny_blok.exe: CMakeFiles/Posledny_blok.dir/objects1.rsp
Posledny_blok.exe: CMakeFiles/Posledny_blok.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\Users\User\CLionProjects\Posledny_blok\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable Posledny_blok.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\Posledny_blok.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Posledny_blok.dir/build: Posledny_blok.exe

.PHONY : CMakeFiles/Posledny_blok.dir/build

CMakeFiles/Posledny_blok.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\Posledny_blok.dir\cmake_clean.cmake
.PHONY : CMakeFiles/Posledny_blok.dir/clean

CMakeFiles/Posledny_blok.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Users\User\CLionProjects\Posledny_blok C:\Users\User\CLionProjects\Posledny_blok C:\Users\User\CLionProjects\Posledny_blok\cmake-build-debug C:\Users\User\CLionProjects\Posledny_blok\cmake-build-debug C:\Users\User\CLionProjects\Posledny_blok\cmake-build-debug\CMakeFiles\Posledny_blok.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/Posledny_blok.dir/depend
