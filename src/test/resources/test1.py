import numpy as np
import sys


def run(file_path):

    return np.sum([1,2,3])


if __name__ == '__main__':
    a = []
    for i in range(1, len(sys.argv)):
        a.append((int(sys.argv[i])))

    print(run(a[0]))