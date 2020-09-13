public class Cell {
    char state; // alive = '#', dead = '0'

    Cell(char state) {
        this.state = state;
    }

    Cell getState(Cell c1, Cell c2, Cell c3, Cell c4, Cell c5, Cell c6, Cell c7, Cell c8) {
        int cellsAround = 0;

        if (c1.state == '#') {
            cellsAround++;
        }
        if (c2.state == '#') {
            cellsAround++;
        }
        if (c3.state == '#') {
            cellsAround++;
        }
        if (c4.state == '#') {
            cellsAround++;
        }
        if (c5.state == '#') {
            cellsAround++;
        }
        if (c6.state == '#') {
            cellsAround++;
        }
        if (c7.state == '#') {
            cellsAround++;
        }
        if (c8.state == '#') {
            cellsAround++;
        }

        if (cellsAround < 2 && this.state == '#') {
            return new Cell('0');
        }

        if (cellsAround > 3 && this.state == '#') {
            return new Cell('0');
        }

        if (cellsAround == 3 && this.state == '0') {
            return new Cell('#');
        }

        if (cellsAround != 3 && this.state == '0') {
            return new Cell('0');
        }

        return new Cell('#');
    }
}