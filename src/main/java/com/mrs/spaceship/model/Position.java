package com.mrs.spaceship.model;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Position moveUp() { return new Position(this.getX(), this.getY() - 1); }

    public Position moveDown() { return new Position(this.getX(), this.getY() + 1); }

    public Position moveLeft() { return new Position(this.getX() - 1, this.getY()); }

    public Position moveRight() { return new Position(this.getX() + 1, this.getY()); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return x == p.getX() && y == p.getY();
    }

    @Override
    public int hashCode() {
        return ((int)this.x ^ (int)this.y);
    }
}
