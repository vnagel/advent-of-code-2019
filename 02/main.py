from functools import reduce
from operator import add, mul

MEMORY_FILENAME = "memory.txt"
NUM_INSTR_VALS = 4
ADD_OPCODE = 1
MULT_OPCODE = 2
HALT_OPCODE = 99
DESIRED_OUTPUT = 19690720
OUTPUT_ADDR = 0
NOUN_ADDR = 1
VERB_ADDR = 2


def run_program(memory):
    instr_ptr_addr = 0
    while True:
        opcode = memory[instr_ptr_addr]
        if opcode == ADD_OPCODE or opcode == MULT_OPCODE:
            op = add if opcode == ADD_OPCODE else mul
            param0_addr = memory[instr_ptr_addr + 1]
            param1_addr = memory[instr_ptr_addr + 2]
            param3_addr = memory[instr_ptr_addr + 3]
            memory[param3_addr] = op(memory[param0_addr], memory[param1_addr])
        elif opcode == HALT_OPCODE:
            break
        else:
            raise Exception("Encountered unknown opcode")
        instr_ptr_addr += NUM_INSTR_VALS


def read_memory(memory_filename):
    with open(memory_filename) as memory_file:
        memory_strs = memory_file.read().split(sep=',')
        memory_nums = list(map(int, memory_strs))
        return memory_nums


def find_inputs_to_produce_output(memory, output):
    for noun in range(100):
        for verb in range(100):
            memory_copy = memory.copy()
            memory_copy[NOUN_ADDR] = noun
            memory_copy[VERB_ADDR] = verb
            run_program(memory_copy)
            if memory_copy[OUTPUT_ADDR] == output:
                return noun, verb


def combine_noun_verb(noun, verb):
    return 100 * noun + verb


if __name__ == "__main__":
    memory = read_memory(MEMORY_FILENAME)
    noun, verb = find_inputs_to_produce_output(memory, DESIRED_OUTPUT)
    print(combine_noun_verb(noun, verb))
