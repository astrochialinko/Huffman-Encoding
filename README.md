# Huffman-Encoding

- CSC 345 Project (Fall 2023)
- Authors: Andres Silva-Castellanos, Luis Felix, Chia-Lin Ko, and Selina Lu

## Presentation
- [Slide Presentation](https://drive.google.com/file/d/1qm-f9cGYqphoEComYSFPiTEz1Qq3W2zG/view?usp=sharing)
- [Video Presentation](https://youtu.be/m1iVB1P_iDM)

  [![Watch the video](https://img.youtube.com/vi/m1iVB1P_iDM/maxresdefault.jpg)](https://youtu.be/m1iVB1P_iDM)


## What the code does?

The code aims to construct a Huffman tree by taking input in the form of Node objects, each containing a name and a frequency value. These elements are organized in min-heap order as an array, with the minimum values used to construct the Huffman tree from the bottom up. The final step involves traversing the constructed tree to verify its accuracy and observe the results. 

Furthermore, in addition to Huffman Encoding, the code also implements another encoding algorithm called Shannon-Fano Coding, which employs a top-down approach in contrast to Huffman's bottom-up method. This provides an alternative method for encoding data, and the code includes test cases and videos showcasing its functionality with various test scenarios.

## How to run the code?

To run the tests, run the program from either of the two files that end in 'Test'. To create new tests, you can follow the format of the existing tests with your own values and run them the same way. 

## File structures

```
.
├── README.md
└── src
    ├── HuffmanBuilder.java
    ├── HuffmanTest.java
    ├── MinHeap.java
    ├── Node.java
    ├── ShannonFano.java
    └── ShannonFanoTest.java
```
The structure is pretty straightforward. There is a file for the actual Huffman and Shannon-Fano algorithms, then a class for the Node object that is used in both, as well as a MinHeap class used in the Huffman Encoding algorithm. Then, there are two test files to run test cases on each of the algorithms.

## References
- [Huffman Coding | Greedy Algo-3](https://www.youtube.com/watch?v=B3y0RsVCyrw&ab_channel=Reducible)
- [Shannon-Fano Algorithm for Data Compression](https://www.geeksforgeeks.org/shannon-fano-algorithm-for-data-compression/)
- [Huffman Codes: An Information Theory Perspective](https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/)

## Acknowledgements

We would like to acknowledge Prof. Melanie Lotz for her guidance and support throughout the semester.
