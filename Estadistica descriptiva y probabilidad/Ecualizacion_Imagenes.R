library(jpeg)
ruta <- file.choose()
img <- readJPEG(ruta)
R <- img[,,1]
plot(0:1,0:1, type='n', axes = FALSE, xlab = "", ylab = "")
rasterImage(R, 0, 0, 1, 1)
hist(R)
T <- function(x){
	r <- sum(R<=x)/(ncol(R)*nrow(R))
	return(r)
	}
res <- matrix(0,nrow = nrow(R), ncol = ncol(R))
for (i in 1:nrow(R))
for (j in 1:ncol(R)){
	res[i,j] <- T(R[i,j])
}
plot(0:1,0:1, type='n', axes = FALSE, xlab = "", ylab = "")
rasterImage(res, 0, 0, 1, 1)
hist(res)