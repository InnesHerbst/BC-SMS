USE [master]
GO
/****** Object:  Database [PRG_Project]    Script Date: 2018/11/12 17:50:49 ******/
CREATE DATABASE [PRG_Project]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PRG_Project', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\PRG_Project.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PRG_Project_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\PRG_Project_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [PRG_Project] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PRG_Project].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PRG_Project] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PRG_Project] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PRG_Project] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PRG_Project] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PRG_Project] SET ARITHABORT OFF 
GO
ALTER DATABASE [PRG_Project] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PRG_Project] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PRG_Project] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PRG_Project] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PRG_Project] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PRG_Project] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PRG_Project] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PRG_Project] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PRG_Project] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PRG_Project] SET  DISABLE_BROKER 
GO
ALTER DATABASE [PRG_Project] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PRG_Project] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PRG_Project] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PRG_Project] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PRG_Project] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PRG_Project] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PRG_Project] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PRG_Project] SET RECOVERY FULL 
GO
ALTER DATABASE [PRG_Project] SET  MULTI_USER 
GO
ALTER DATABASE [PRG_Project] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PRG_Project] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PRG_Project] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PRG_Project] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [PRG_Project] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'PRG_Project', N'ON'
GO
USE [PRG_Project]
GO
/****** Object:  Table [dbo].[Administrator]    Script Date: 2018/11/12 17:50:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Administrator](
	[Admin_ID] [varchar](13) NOT NULL,
	[Admin_First_Name] [varchar](50) NULL,
	[Admin_Initials] [varchar](50) NULL,
	[Admin_Last_Name] [varchar](50) NULL,
	[Admin_DoB] [datetime] NULL,
	[Admin_Gender] [varchar](50) NULL,
	[Admin_Phone] [varchar](50) NULL,
	[Admin_Email] [varchar](50) NULL,
	[Admin_Password] [varchar](50) NULL,
	[Admin_Address_1] [varchar](50) NULL,
	[Admin_Address_2] [varchar](50) NULL,
	[Campus_ID] [int] NULL,
 CONSTRAINT [PK_Administrator] PRIMARY KEY CLUSTERED 
(
	[Admin_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Campus]    Script Date: 2018/11/12 17:50:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Campus](
	[Campus_ID] [int] IDENTITY(1,1) NOT NULL,
	[Campus_Name] [varchar](50) NULL,
	[Campus_Address_1] [varchar](50) NULL,
	[Campus_Address_2] [varchar](50) NULL,
	[Campus_Email] [varchar](50) NULL,
	[Campus_Work] [varchar](50) NULL,
 CONSTRAINT [PK_Campus] PRIMARY KEY CLUSTERED 
(
	[Campus_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Category]    Script Date: 2018/11/12 17:50:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Category](
	[Category_ID] [int] IDENTITY(1,1) NOT NULL,
	[Category_Name] [varchar](50) NULL,
	[Category_Desc] [varchar](50) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[Category_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Department]    Script Date: 2018/11/12 17:50:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Department](
	[Department_ID] [int] IDENTITY(1,1) NOT NULL,
	[Department_Name] [varchar](50) NULL,
	[Department_Desc] [varchar](50) NULL,
 CONSTRAINT [PK_Department] PRIMARY KEY CLUSTERED 
(
	[Department_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Order]    Script Date: 2018/11/12 17:50:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Order](
	[Order_ID] [int] IDENTITY(1,1) NOT NULL,
	[Order_Desc] [varchar](50) NULL,
	[Order_Date] [datetime] NULL,
	[Product_ID] [int] NULL,
	[Order_Quantity] [int] NULL,
	[Staff_ID] [varchar](13) NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[Order_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Product]    Script Date: 2018/11/12 17:50:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Product](
	[Product_ID] [int] IDENTITY(1,1) NOT NULL,
	[Product_Name] [varchar](50) NULL,
	[Product_Price] [money] NULL,
	[Category_ID] [int] NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[Product_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PurchaseOrder]    Script Date: 2018/11/12 17:50:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PurchaseOrder](
	[PurchaseOrder_ID] [int] IDENTITY(1,1) NOT NULL,
	[Order_ID] [int] NULL,
	[PurchaseOrder_Desc] [varchar](50) NULL,
	[PurchaseOrder_Date] [datetime] NULL,
	[Product_ID] [int] NULL,
	[PurchaseOrder_Quantity] [int] NULL,
	[Admin_ID] [varchar](13) NULL,
 CONSTRAINT [PK_PurchaseOrder] PRIMARY KEY CLUSTERED 
(
	[PurchaseOrder_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Staff]    Script Date: 2018/11/12 17:50:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Staff](
	[Staff_ID] [varchar](13) NOT NULL,
	[Staff_First_Name] [varchar](50) NULL,
	[Staff_Initials] [varchar](10) NULL,
	[Staff_Last_Name] [varchar](50) NULL,
	[Staff_DoB] [datetime] NULL,
	[Staff_Gender] [varchar](50) NULL,
	[Staff_Phone] [varchar](50) NULL,
	[Staff_Email] [varchar](50) NULL,
	[Staff_Address_1] [varchar](50) NULL,
	[Staff_Address_2] [varchar](50) NULL,
	[Staff_Campus_ID] [int] NULL,
	[Staff_Department_ID] [int] NULL,
	[Staff_Password] [varchar](50) NULL,
	[Staff_Confirm] [varchar](10) NULL,
 CONSTRAINT [PK_Staff] PRIMARY KEY CLUSTERED 
(
	[Staff_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Stock]    Script Date: 2018/11/12 17:50:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Stock](
	[Stock_ID] [int] IDENTITY(1,1) NOT NULL,
	[product_ID] [int] NULL,
	[product_Quantity] [int] NULL,
	[department_ID] [int] NULL,
	[campus_ID] [int] NULL,
	[Stock_Confirmation] [varchar](50) NULL,
 CONSTRAINT [PK_Stock] PRIMARY KEY CLUSTERED 
(
	[Stock_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Administrator]  WITH CHECK ADD  CONSTRAINT [FK_Administrator_Campus] FOREIGN KEY([Campus_ID])
REFERENCES [dbo].[Campus] ([Campus_ID])
GO
ALTER TABLE [dbo].[Administrator] CHECK CONSTRAINT [FK_Administrator_Campus]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Product] FOREIGN KEY([Product_ID])
REFERENCES [dbo].[Product] ([Product_ID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Product]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Staff1] FOREIGN KEY([Staff_ID])
REFERENCES [dbo].[Staff] ([Staff_ID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Staff1]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([Category_ID])
REFERENCES [dbo].[Category] ([Category_ID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO
ALTER TABLE [dbo].[PurchaseOrder]  WITH CHECK ADD  CONSTRAINT [FK_PurchaseOrder_Administrator] FOREIGN KEY([Admin_ID])
REFERENCES [dbo].[Administrator] ([Admin_ID])
GO
ALTER TABLE [dbo].[PurchaseOrder] CHECK CONSTRAINT [FK_PurchaseOrder_Administrator]
GO
ALTER TABLE [dbo].[PurchaseOrder]  WITH CHECK ADD  CONSTRAINT [FK_PurchaseOrder_Order] FOREIGN KEY([Order_ID])
REFERENCES [dbo].[Order] ([Order_ID])
GO
ALTER TABLE [dbo].[PurchaseOrder] CHECK CONSTRAINT [FK_PurchaseOrder_Order]
GO
ALTER TABLE [dbo].[PurchaseOrder]  WITH CHECK ADD  CONSTRAINT [FK_PurchaseOrder_Product] FOREIGN KEY([Product_ID])
REFERENCES [dbo].[Product] ([Product_ID])
GO
ALTER TABLE [dbo].[PurchaseOrder] CHECK CONSTRAINT [FK_PurchaseOrder_Product]
GO
ALTER TABLE [dbo].[Staff]  WITH CHECK ADD  CONSTRAINT [FK_Staff_Campus1] FOREIGN KEY([Staff_Campus_ID])
REFERENCES [dbo].[Campus] ([Campus_ID])
GO
ALTER TABLE [dbo].[Staff] CHECK CONSTRAINT [FK_Staff_Campus1]
GO
ALTER TABLE [dbo].[Staff]  WITH CHECK ADD  CONSTRAINT [FK_Staff_Department1] FOREIGN KEY([Staff_Department_ID])
REFERENCES [dbo].[Department] ([Department_ID])
GO
ALTER TABLE [dbo].[Staff] CHECK CONSTRAINT [FK_Staff_Department1]
GO
/****** Object:  StoredProcedure [dbo].[SP_FetchStock]    Script Date: 2018/11/12 17:50:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SP_FetchStock]
AS
SELECT s.Stock_ID,p.Product_Name,p.Product_Price,s.product_Quantity,c.Category_Name,c.Category_Desc 
FROM Stock s 
INNER JOIN Product p
ON (s.product_ID = p.Product_ID) 
INNER JOIN Category c
ON (p.Category_ID = c.Category_ID)
Where s.Stock_Confirmation = 'Yes'
GO
/****** Object:  StoredProcedure [dbo].[SP_FetchUnAuthStock]    Script Date: 2018/11/12 17:50:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SP_FetchUnAuthStock]
AS
SELECT s.Stock_ID,p.Product_Name,p.Product_Price,s.product_Quantity,c.Category_Name,c.Category_Desc 
FROM Stock s 
INNER JOIN Product p
ON (s.product_ID = p.Product_ID) 
INNER JOIN Category c
ON (p.Category_ID = c.Category_ID)
Where s.Stock_Confirmation = 'No'
GO
/****** Object:  StoredProcedure [dbo].[SP_View_Campus_Stock]    Script Date: 2018/11/12 17:50:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SP_View_Campus_Stock]
@campID int
AS
SELECT s.Stock_ID,p.Product_Name,p.Product_Price,s.product_Quantity,c.Category_Name,c.Category_Desc 
FROM Stock s 
INNER JOIN Product p
ON (s.product_ID = p.Product_ID) 
INNER JOIN Category c
ON (p.Category_ID = c.Category_ID)
WHERE campus_ID = @campID
GO
/****** Object:  StoredProcedure [dbo].[SP_ViewStock]    Script Date: 2018/11/12 17:50:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SP_ViewStock]
AS
SELECT s.Stock_ID,p.Product_Name,p.Product_Price,s.product_Quantity,c.Category_Name,c.Category_Desc 
FROM Stock s 
INNER JOIN Product p
ON (s.product_ID = p.Product_ID) 
INNER JOIN Category c
ON (p.Category_ID = c.Category_ID)
GO
USE [master]
GO
ALTER DATABASE [PRG_Project] SET  READ_WRITE 
GO
