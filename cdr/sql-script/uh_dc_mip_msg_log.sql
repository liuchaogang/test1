USE [MIP_DC_DEMO]
GO
/****** Object:  Table [dbo].[uh_dc_mip_msg_log]    Script Date: 2017/8/3 11:32:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[uh_dc_mip_msg_log](
	[id] [varchar](100) NOT NULL,
	[msg_id] [varchar](100) NULL,
	[service_id] [varchar](50) NULL,
	[model_type] [varchar](50) NULL,
	[dto_name] [varchar](max) NULL,
	[msg_writer] [varchar](200) NULL,
	[business_tables] [varchar](200) NULL,
	[msg_content] [xml] NULL,
	[json_content] [varchar](max) NULL,
	[msg_status] [char](1) NULL,
	[process_info] [varchar](max) NULL,
	[create_time] [datetime] NULL,
	[update_time] [datetime] NULL,
 CONSTRAINT [PK_uh_dc_mip_msg_log] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IDX_uh_dc_mip_msg_log_msg_id]    Script Date: 2017/8/3 11:32:46 ******/
CREATE NONCLUSTERED INDEX [IDX_uh_dc_mip_msg_log_msg_id] ON [dbo].[uh_dc_mip_msg_log]
(
	[msg_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
