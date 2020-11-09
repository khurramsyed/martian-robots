package com.leanmentors.martianrobots;

public enum Instruction {

    L('L'),
    R('R'),
    F('F');

    Instruction(Character instr) {
        this.instruction = instr;
    }

    private Character instruction;


}
