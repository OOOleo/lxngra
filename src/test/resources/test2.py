import numpy as np
import sys


def run(file_path):

    return np.sum([1,2,3])


if __name__ == '__main__':
    a = []
    for i in range(len(sys.argv)):
        a.append(str(argv[i]))

    print(a[0])
    print(run(a[0]))