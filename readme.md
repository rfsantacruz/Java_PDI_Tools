# Digital Image Processing Tools
This is a collection of traditional digital image processing algorithms, e.g., image filtering, restoration and morphological operations, implemented in JAVA. This **is not** an optimized code, since this is a self-study project developed while studying the book [Digital Image Processing](https://www.amazon.com/Digital-Image-Processing-Rafael-Gonzalez/dp/013168728X) by Rafael C. Gonzalez and Richards E. Woods.

## Contents

### Image enhancement in Spatial Domain: 
We first focus on image processing on the spatial domain. We implement basic [gray level transformations](./src/intensityFiltersPack) pipelines as well as concrete operations like logarithmic, gamma, and negative. Second, we demonstrate how to perform enhancements by image [histogram processing](./src/HistogramPack). Third, we code handy [arithmetic and logical pixel-wise operations](./src/SetOperationsPack). Finally, we develop the standard [spatial filtering operation](./src/SpatialFiltersPack), [smoothing filters](./src/SpatialFiltersPack) like median and mean, and [sharpening filters](./src/SpatialFiltersPack) based on gradient operators.

### Image enhancement in Spatial Domain:
Some operations are easy to compute in the frequency domain. Then, we develop an engine to perform the Fourier and Inverse-Fourier transform which accomplish the [space-frequency transformations](./src/FrequencyFiltersPack/FrequencyFilterExecutor.java) of images. Moreover, we implement the [homomorphic filter](./src/FrequencyFiltersPack/HomomorficFilter.java) as an example of how to use such an engine. 

### Morphological image processing:
[Morphological operations](./src/MoforlogicOperationsPack) are an interesting class of binary image transformations. Here, we code from basic [erosion](./src/MoforlogicOperationsPack/ErosionMorfologicOperator.java) and [dilatation](./src/MoforlogicOperationsPack/DilatationMorfologicOperator.java) operations, passing trough opening and closing, and finishing with applications of region filling and shape detection. 

See [ImageProcessor class](./src/ProcessorPack/ImageProcessor.java) for instructions on how to use these algorithms. However, note that **this toolbox is not a substitute for Matlab or OpenCV image processing toolboxes**, it is just a collection of programming exercises to better understand how image processing algorithms works.
