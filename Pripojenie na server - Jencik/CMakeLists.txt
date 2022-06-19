cmake_minimum_required(VERSION 3.17)
project(Posledny_blok)
link_libraries(ws2_32 wsock32)

set(CMAKE_CXX_STANDARD 14)

add_executable(Posledny_blok main.cpp)