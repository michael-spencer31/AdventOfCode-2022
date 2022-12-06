with open("input.txt") as file:
	lines = [i for i in file.read().splitlines()]

fully_covered = 0
partial_cover = 0

for line in lines:

	# start by spliting the two ranges apart
	section1, section2 = line.split(",")

	# now split the numbers in each range apart
	section1_start, section1_end = section1.split("-")
	section2_start, section2_end = section2.split("-")

	# find the numbers in range of both sections
	range_1 = [num for num in range(int(section1_start), int(section1_end) + 1)]
	range_2 = [num for num in range(int(section2_start), int(section2_end) + 1)]

	# find the ranges that fully cover each other
	if all(x in range_1 for x in range_2) or all(x in range_2 for x in range_1):
		fully_covered += 1 

	# find the ranges that partially cover each other
	if any(x in range_1 for x in range_2):
		partial_cover += 1

# print out the solutions!
print(fully_covered)
print(partial_cover)