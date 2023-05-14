FROM archlinux:latest

RUN pacman -Syyu --noconfirm
RUN pacman -S jdk17-openjdk --noconfirm
COPY . .
RUN java src/Main.java

CMD ["java", "src/Main.java"]
